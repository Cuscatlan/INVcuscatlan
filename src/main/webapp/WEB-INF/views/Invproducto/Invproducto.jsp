<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridInvproducto" var="urlgridInvproducto" />
        <c:url value="/exportInvproducto" var="recordsExportUrlInvproducto" />
        <c:url value="/saveInvproducto" var="urlsaveInvproducto" />
        <c:url value="/deleteInvproducto" var="urldeleteInvproducto" />
    </head>
    <body>
        <div class="wrapper">
            <!-- top navbar-->
            <%@include file="/WEB-INF/views/header.jsp" %>
            <!-- sidebar-->
            <%@include file="/WEB-INF/views/menu.jsp" %>
            <!-- offsidebar-->
            <%@include file="/WEB-INF/views/settings.jsp" %>
            <!-- Main section-->
            <section>
                <!-- Page content-->
                <div class="content-wrapper">
                    <div class="row">
                        <h3>Invproducto
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
                            <script type="text/javascript">
                                (function (window, document, $, undefined) {
                                    var selectrow = 0;
                                    $(function () {
                                        var jqGridInvproducto = $("#jqGridInvproducto");
                                        var formInvproducto = $("#formInvproducto");
                                        var modalInvproducto = $("#modalInvproducto");
                                        jqGridInvproducto.jqGrid({
                                            url: '${pageContext.request.contextPath}/gridInvproducto',
                                            datatype: "json",
                                            colModel: [
                                                {label: 'IDPRODUCTO', name: 'idproducto', width: 50, align: 'center', key: true, hidden: true}
                                                , {label: 'NOMBREPRODUCTO', name: 'nombreproducto', width: 50, align: 'center', editable: true, edittype: "text", editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                                                    if (e.keyCode == 13 || e.keyCode == 27)
                                                                        return false;
                                                                }}]}
                                                }
                                                , {label: 'CODIGOPRODUCTO', name: 'codigoproducto', width: 50, align: 'center', editable: true, edittype: "text", editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                                                    if (e.keyCode == 13 || e.keyCode == 27)
                                                                        return false;
                                                                }}]}
                                                }
                                                , {label: 'UBICACIONFISICA', name: 'ubicacionfisica', width: 50, align: 'center', editable: true, edittype: "text", editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                                                    if (e.keyCode == 13 || e.keyCode == 27)
                                                                        return false;
                                                                }}]}
                                                }
                                                , {label: 'IDFAMILIAPRODUCTO', name: 'invfamiliaproductoDelegate', hidden: true}
                                                , {label: 'IDFAMILIAPRODUCTO', name: 'invfamiliaproductoDescriptionDelegate', align: 'center', width: 50, stype: "select", editable: true, edittype: "select",
                                                    searchoptions: {
                                                        dataUrl: '${pageContext.request.contextPath}/cbofilterInvfamiliaproducto',
                                                        buildSelect: function (response) {
                                                            var obj = $.parseJSON(response);
                                                            var html = "<select><option></option>";
                                                            for (i in obj)
                                                                html += "<option value=" + obj[i].value + ">" + obj[i].description + "</option>";
                                                            html += "</select>";
                                                            return html;
                                                        },
                                                        dataInit: function (element) {
                                                            $(element).select2({placeholder: "Todos", allowClear: true});
                                                        }
                                                    }
                                                    , editoptions: {
                                                        dataEvents: [
                                                            {
                                                                type: 'change', fn: function (e) {
                                                                    jqGridPrueba.jqGrid("setCell", selectrow, "padreDelegate", $("#" + selectrow + "_padreDescriptionDelegate").val());
                                                                }
                                                            },
                                                            {type: "keydown", "fn": function (e) {
                                                                    if (e.keyCode == 13 || e.keyCode == 27)
                                                                        return false;
                                                                }
                                                            }
                                                        ],
                                                        dataInit: function (element) {
                                                            $.ajax({
                                                                url: '${pageContext.request.contextPath}/cbofilterPadre',
                                                                dataType: 'text',
                                                                type: 'GET',
                                                                success: function (data) {
                                                                    var obj = $.parseJSON(data);
                                                                    var row = jqGridPrueba.jqGrid('getRowData', selectrow);
                                                                    var html = "<select data-placeholder=\"Todos\" class=\"chosen-select input-md form-control\" ><option></option>";
                                                                    for (i in obj) {
                                                                        html += "<option ";
                                                                        if (obj[i].value == row.padreDelegate && selectrow != "") {
                                                                            html += " selected ";
                                                                        }
                                                                        html += " value=" + obj[i].value + ">" + obj[i].description + "</option>";
                                                                    }
                                                                    html += "</select>";
                                                                    element.id = selectrow + "_padreDescriptionDelegate";
                                                                    $(element).html(html);
                                                                    $(element).width($("#gs_padreDescriptionDelegate").width()).select2({placeholder: "Todos", allowClear: true});
                                                                }
                                                            });
                                                        }
                                                    }
                                                }
                                                , {label: 'IDTIPOPRODUCTO', name: 'invtipoproductoDelegate', hidden: true}
                                                , {label: 'IDTIPOPRODUCTO', name: 'invtipoproductoDescriptionDelegate', align: 'center', width: 50, stype: "select", editable: true, edittype: "select",
                                                    searchoptions: {
                                                        dataUrl: '${pageContext.request.contextPath}/cbofilterInvtipoproducto',
                                                        buildSelect: function (response) {
                                                            var obj = $.parseJSON(response);
                                                            var html = "<select><option></option>";
                                                            for (i in obj)
                                                                html += "<option value=" + obj[i].value + ">" + obj[i].description + "</option>";
                                                            html += "</select>";
                                                            return html;
                                                        },
                                                        dataInit: function (element) {
                                                            $(element).select2({placeholder: "Todos", allowClear: true});
                                                        }
                                                    }
                                                    , editoptions: {
                                                        dataEvents: [
                                                            {
                                                                type: 'change', fn: function (e) {
                                                                    jqGridPrueba.jqGrid("setCell", selectrow, "padreDelegate", $("#" + selectrow + "_padreDescriptionDelegate").val());
                                                                }
                                                            },
                                                            {type: "keydown", "fn": function (e) {
                                                                    if (e.keyCode == 13 || e.keyCode == 27)
                                                                        return false;
                                                                }
                                                            }
                                                        ],
                                                        dataInit: function (element) {
                                                            $.ajax({
                                                                url: '${pageContext.request.contextPath}/cbofilterPadre',
                                                                dataType: 'text',
                                                                type: 'GET',
                                                                success: function (data) {
                                                                    var obj = $.parseJSON(data);
                                                                    var row = jqGridPrueba.jqGrid('getRowData', selectrow);
                                                                    var html = "<select data-placeholder=\"Todos\" class=\"chosen-select input-md form-control\" ><option></option>";
                                                                    for (i in obj) {
                                                                        html += "<option ";
                                                                        if (obj[i].value == row.padreDelegate && selectrow != "") {
                                                                            html += " selected ";
                                                                        }
                                                                        html += " value=" + obj[i].value + ">" + obj[i].description + "</option>";
                                                                    }
                                                                    html += "</select>";
                                                                    element.id = selectrow + "_padreDescriptionDelegate";
                                                                    $(element).html(html);
                                                                    $(element).width($("#gs_padreDescriptionDelegate").width()).select2({placeholder: "Todos", allowClear: true});
                                                                }
                                                            });
                                                        }
                                                    }
                                                }
                                            ],
                                            viewrecords: true,
                                            gridComplete: function () {
                                                $("#pager_plus").removeClass("ui-state-disabled");
                                                $("#pager_edit").removeClass("ui-state-disabled");
                                                $("#pager_save").addClass("ui-state-disabled");
                                                $("#pager_cancel").addClass("ui-state-disabled");
                                            },
                                            autowidth: true,
                                            shrinkToFit: true,
                                            height: 240,
                                            rowNum: 100,
                                            rowList: [100, 200, 500, 1000],
                                            loadonce: false,
                                            caption: "Lista de Datos",
                                            hidegrid: false,
                                            jsonReader: {
                                                root: "rows",
                                                page: "page",
                                                repeatitems: false,
                                                total: "total",
                                                records: "records",
                                                cell: "cell",
                                                id: "id"
                                            },
                                            pager: "#jqGridInvproductoPager"
                                        });

                                        jqGridInvproducto.jqGrid('filterToolbar', {stringResult: true, searchOnEnter: true, defaultSearch: "cn"});

                                        jqGridInvproducto.jqGrid('navGrid', '#jqGridInvproductoPager',
                                                {edit: false, add: false, del: false, search: false},
                                                {}, {}, {},
                                                {// search
                                                    closeOnEscape: true,
                                                    multipleSearch: true,
                                                    closeAfterSearch: true
                                                });

                                        jqGridInvproducto.jqGrid('navButtonAdd', '#jqGridInvproductoPager',
                                                {id: 'pager_preview', caption: '', title: 'agregar',
                                                    onClickButton: function (e) {
                                                        var row = jqGridInvproducto.jqGrid('getGridParam', 'selrow');
                                                        if (row != null) {
                                                            var rowData = jqGridInvproducto.getRowData(row);
                                                            populateForm(formInvproducto, rowData);
                                                            $("#btnModalSubmit").prop('disabled', true);
                                                            modalInvproducto.modal('toggle');
                                                        } else {
                                                            swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                                        }
                                                    },
                                                    buttonicon: 'ui-icon-zoomin'
                                                }
                                        );
                                        jqGridInvproducto.jqGrid('navButtonAdd', '#jqGridInvproductoPager', {
                                            id: 'pager_plus',
                                            caption: '',
                                            title: 'Agregar',
                                            onClickButton: function (e) {
                                                var emptyItem = [{idproducto: "", porcentaje1: "", nombreproducto: "", precioventa3: "", gravado: "", imagen: "", codigoproducto: "", precioventa4: "", preciocosto: "", porcentaje2: "", presentacion: "", porcentaje: "", preciopromedio: "", descuento: "", porcentaje4: "", ubicacionfisica: "", costo: "", porcentaje3: "", precioventa2: "", precioventa1: "", idfamiliaproductoDelegate: "", idfamiliaproductoDescriptionDelegate: "", idtipoproductoDelegate: "", idtipoproductoDescriptionDelegate: ""}];
                                                jqGridInvproducto.addRowData("id", emptyItem);
                                                jqGridInvproducto.jqGrid('editRow', "", true);
                                                jqGridInvproducto.setSelection("", true);
                                                $("#pager_plus").addClass("ui-state-disabled");
                                                $("#pager_edit").addClass("ui-state-disabled");
                                                $("#pager_cancel").removeClass("ui-state-disabled");
                                                $("#pager_save").removeClass("ui-state-disabled");
                                                selectrow = "";
                                            },
                                            buttonicon: 'ui-icon-plus'
                                        });

                                        jqGridInvproducto.jqGrid('navButtonAdd', '#jqGridInvproductoPager', {
                                            id: 'pager_edit',
                                            caption: '',
                                            title: 'Editar',
                                            onClickButton: function (e) {
                                                 var selRowId = jqGridInvproducto.jqGrid('getGridParam', 'selrow');
                                                 if (selRowId == null) {
                                                    swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                                    return;
                                                }
                                                jqGridInvproducto.jqGrid('editRow', selRowId, true);
                                                jqGridInvproducto.setSelection(selRowId, true);
                                                $("#pager_plus").addClass("ui-state-disabled");
                                                $("#pager_edit").addClass("ui-state-disabled");
                                                $("#pager_cancel").removeClass("ui-state-disabled");
                                                $("#pager_save").removeClass("ui-state-disabled");
                                                selectrow = selRowId;
                                            },
                                            buttonicon: 'ui-icon ui-icon-pencil'
                                        });

                                        jqGridInvproducto.jqGrid('navButtonAdd', '#jqGridInvproductoPager',
                                                {id: 'pager_delete', caption: '', title: 'eliminar',
                                                    onClickButton: function (e) {
                                                        var selRowId = jqGridInvproducto.jqGrid('getGridParam', 'selrow');

                                                        if (selRowId == null) {
                                                            swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                                            return;
                                                        }
                                                        var row = jqGridInvproducto.jqGrid('getRowData', selRowId);

                                                        swal({
                                                            title: "¿Esta seguro?",
                                                            text: "¡Se eliminara el registro!",
                                                            type: "warning",
                                                            showCancelButton: true,
                                                            confirmButtonColor: "#5D9CEC",
                                                            confirmButtonText: "Sí, eliminar registro!",
                                                            cancelButtonText: "No, cancelar!",
                                                            closeOnConfirm: false,
                                                            closeOnCancel: false
                                                        }, function (isConfirm) {
                                                            if (isConfirm) {
                                                                $.ajax({
                                                                    data: row,
                                                                    url: '${pageContext.request.contextPath}/deleteInvproducto',
                                                                    type: "POST",
                                                                    success: function (response) {
                                                                        swal("Elimnado!", "Su registro se elimino exitosamente.", "success");
                                                                        $("button[data-dismiss='modal']").click();
                                                                        jqGridInvproducto.trigger("reloadGrid");
                                                                        return false;
                                                                    },
                                                                    error: function (x, e) {
                                                                        alert("Ocurrio un error");
                                                                    }
                                                                });
                                                            } else {
                                                                swal("Cancelado", "Su petición ha sido cancelada.", "error");
                                                                $("button[data-dismiss='modal']").click();
                                                            }
                                                        });
                                                    },
                                                    buttonicon: 'ui-icon-trash'
                                                }
                                        );
                                        jqGridInvproducto.jqGrid('navButtonAdd', '#jqGridInvproductoPager',
                                                {id: 'pager_save', caption: '', title: 'Guardar',
                                                    onClickButton: function (e) {


                                                        jqGridInvproducto.jqGrid('saveRow', selectrow);
                                                        var row = jqGridInvproducto.jqGrid('getRowData', selectrow);

                                                        swal({
                                                            title: "¿Esta seguro?",
                                                            text: "¡Se ingresara un nuevo registro!",
                                                            type: "warning",
                                                            showCancelButton: true,
                                                            confirmButtonColor: "#5D9CEC",
                                                            confirmButtonText: "Sí, guardar registro!",
                                                            cancelButtonText: "No, cancelar!",
                                                            closeOnConfirm: false,
                                                            closeOnCancel: false
                                                        }, function (isConfirm) {
                                                            if (isConfirm) {
                                                                $.ajax({
                                                                    data: row,
                                                                    url: '${pageContext.request.contextPath}/saveInvproducto',
                                                                    type: "POST",
                                                                    success: function (response) {
                                                                        swal("Guardado!", "Su registro se guardo exitosamente.", "success");
                                                                        $("button[data-dismiss='modal']").click();
                                                                        jqGridInvproducto.trigger("reloadGrid");
                                                                        return false;
                                                                    },
                                                                    error: function (x, e) {
                                                                        alert("Ocurrio un error");
                                                                    }
                                                                });
                                                            } else {
                                                                swal("Cancelado", "Su petición ha sido cancelada.", "error");
                                                                $("button[data-dismiss='modal']").click();
                                                            }
                                                        });

                                                    },
                                                    buttonicon: 'ui-icon-disk'
                                                }
                                        );

                                        jqGridInvproducto.jqGrid('navButtonAdd', '#jqGridInvproductoPager',
                                                {id: 'pager_cancel', caption: '', title: 'Cancelar',
                                                    onClickButton: function (e) {
                                                        reloadEditGrid();
                                                    },
                                                    buttonicon: 'ui-icon-cancel'
                                                }
                                        );
                                        jqGridInvproducto.jqGrid('navButtonAdd', '#jqGridInvproductoPager', {
                                            id: 'pager_excel',
                                            caption: '',
                                            title: 'Export',
                                            onClickButton: function (e) {
                                                exportInvproductoGrid();
                                            },
                                            buttonicon: 'ui-icon-calculator'
                                        });

                                        function reloadEditGrid() {
                                            $("#pager_plus").removeClass("ui-state-disabled");
                                            $("#pager_edit").removeClass("ui-state-disabled");
                                            $("#pager_save").addClass("ui-state-disabled");
                                            $("#pager_cancel").addClass("ui-state-disabled");
                                            if (selectrow == "") {
                                                jqGridInvproducto.jqGrid('delRowData', "");
                                            } else {
                                                jqGridInvproducto.jqGrid('restoreRow', selectrow);
                                            }
                                            selectrow = "";
                                        }
                                        function exportInvproductoGrid()
                                        {
                                            $('#filters').val(jqGridInvproducto.jqGrid('getGridParam', 'postData').filters);
                                            $('#jqGridInvproductoGridParameters').submit();
                                        }

                                        $(window).on('resize', function () {
                                            var width = $('.jqgrid-responsive').width();
                                            jqGridInvproducto.setGridWidth(width);
                                        }).resize();

                                    });
                                })(window, document, window.jQuery);
                            </script>

                            <table id="jqGridInvproducto"></table>
                            <table id="jqGridInvproductoPager"></table>

                            <form method="post" id="jqGridInvproductoGridParameters" action="/exportInvproducto"  target="_blank">
                                <input type="hidden" name="filters" id="filters" value=""/>
                                <input type="hidden" id="jqgridExport"/> 
                            </form>

                        </div>
                    </div>
                </div>
            </section>
            <!-- Page footer-->
            <%@include file="/WEB-INF/views/footer.jsp" %>
        </div>

        <!-- Modal-->
        <div id="modalInvproducto" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                        <form method="POST" id="formInvproducto" action="${urlsaveInvproducto}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">IDPRODUCTO</label>
                                        <div class="col-lg-10">

                                            <jf:numberbox  precision="10"    id="idproducto" name="idproducto"  required="true"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PORCENTAJE1</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="porcentaje1" name="porcentaje1"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">NOMBREPRODUCTO</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"   id="nombreproducto" name="nombreproducto"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PRECIOVENTA3</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="precioventa3" name="precioventa3"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">GRAVADO</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="gravado" name="gravado"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">IMAGEN</label>
                                        <div class="col-lg-10">

                                            <input type='file'  id="imagen" name="imagen" />                                         </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">CODIGOPRODUCTO</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="6" maxlength="100"   id="codigoproducto" name="codigoproducto"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PRECIOVENTA4</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="precioventa4" name="precioventa4"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PRECIOCOSTO</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="preciocosto" name="preciocosto"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PORCENTAJE2</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="porcentaje2" name="porcentaje2"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PRESENTACION</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="presentacion" name="presentacion"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PORCENTAJE</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="porcentaje" name="porcentaje"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PRECIOPROMEDIO</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="preciopromedio" name="preciopromedio"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">DESCUENTO</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="descuento" name="descuento"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PORCENTAJE4</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="porcentaje4" name="porcentaje4"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">UBICACIONFISICA</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="15" maxlength="100"   id="ubicacionfisica" name="ubicacionfisica"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">COSTO</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="costo" name="costo"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PORCENTAJE3</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="porcentaje3" name="porcentaje3"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PRECIOVENTA2</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="precioventa2" name="precioventa2"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">PRECIOVENTA1</label>
                                        <div class="col-lg-10">

                                            <jf:textbox  tabindex="2" maxlength="100"  id="precioventa1" name="precioventa1"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">IDFAMILIAPRODUCTO</label>
                                        <div class="col-lg-10">

                                            <jf:combobox url="/Inventario/cbofilterInvfamiliaproducto"   id="invfamiliaproductoDelegate"  name="invfamiliaproducto.idfamiliaproducto"  readonly="true" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">IDTIPOPRODUCTO</label>
                                        <div class="col-lg-10">

                                            <jf:combobox url="/Inventario/cbofilterInvtipoproducto"   id="invtipoproductoDelegate"  name="invtipoproducto.idtipoproducto"  readonly="true" />
                                        </div>
                                    </div>

                                </div>
                                <div class="panel-footer text-right">
                                    <button type="button" data-dismiss="modal" class="btn btn-default">Close</button>
                                    <button id="btnModalSubmit" type="submit" class="btn btn-">Run validation</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


