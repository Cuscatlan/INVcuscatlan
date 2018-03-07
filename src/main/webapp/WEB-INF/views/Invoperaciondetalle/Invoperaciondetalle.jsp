<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridInvoperaciondetalle" var="urlgridInvoperaciondetalle" />
        <c:url value="/exportInvoperaciondetalle" var="recordsExportUrlInvoperaciondetalle" />
        <c:url value="/saveInvoperaciondetalle" var="urlsaveInvoperaciondetalle" />
        <c:url value="/deleteInvoperaciondetalle" var="urldeleteInvoperaciondetalle" />
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
                        <h3>Invoperaciondetalle
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
<script type="text/javascript">
             (function(window, document, $, undefined){
                 var selectrow = 0;
                 $(function(){
                     var jqGridInvoperaciondetalle = $("#jqGridInvoperaciondetalle");
                     var formInvoperaciondetalle = $("#formInvoperaciondetalle");
                     var modalInvoperaciondetalle = $("#modalInvoperaciondetalle");
                    jqGridInvoperaciondetalle.jqGrid({
                         url: '${pageContext.request.contextPath}/gridInvoperaciondetalle',
                         datatype: "json",
                         colModel:[ 
                                                            { label: 'IDDETALLE', name: 'iddetalle', width: 50 ,align:'center',key: true, hidden: true}
                                   ,{ label: 'LOTEDETALLE', name: 'lotedetalle', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'UBICACIONFISICA', name: 'ubicacionfisica', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'IDOPERACION', name: 'invoperacionDelegate',hidden:true} 
                                   ,{ label: 'IDOPERACION', name: 'invoperacionDescriptionDelegate',align:'center', width: 50,stype:"select", editable: true, edittype: "select",
                                           searchoptions: {
                                               dataUrl: '${pageContext.request.contextPath}/cbofilterInvoperacion',
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
                                           ,editoptions: {
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
                                   ,{ label: 'IDPRODUCTO', name: 'invproductoDelegate',hidden:true} 
                                   ,{ label: 'IDPRODUCTO', name: 'invproductoDescriptionDelegate',align:'center', width: 50,stype:"select", editable: true, edittype: "select",
                                           searchoptions: {
                                               dataUrl: '${pageContext.request.contextPath}/cbofilterInvproducto',
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
                                           ,editoptions: {
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
                         rowList: [100,200,500,1000],
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
                         pager: "#jqGridInvoperaciondetallePager"
                    });
                     
                    jqGridInvoperaciondetalle.jqGrid('filterToolbar', {stringResult: true, searchOnEnter: true, defaultSearch: "cn"});
                     
                     jqGridInvoperaciondetalle.jqGrid('navGrid', '#jqGridInvoperaciondetallePager',
                         {edit: false, add: false, del: false, search: false},
                          {}, {}, {},
                          {// search
                              closeOnEscape: true,
                              multipleSearch: true,
                              closeAfterSearch: true
                      });
                     
                  jqGridInvoperaciondetalle.jqGrid('navButtonAdd', '#jqGridInvoperaciondetallePager',
                     {id: 'pager_preview', caption: '', title: 'agregar',
                          onClickButton: function (e) {
                              var row = jqGridInvoperaciondetalle.jqGrid('getGridParam', 'selrow');
                              if (row != null) {
                                  var rowData = jqGridInvoperaciondetalle.getRowData(row);
                                  populateForm(formInvoperaciondetalle, rowData);
                                  $("#btnModalSubmit").prop('disabled', true);
                                  modalInvoperaciondetalle.modal('toggle');
                              } else {
                                  swal("Advertencia", "Por favor seleccione una fila.", "warning");
                              }
                          },
                              buttonicon: 'ui-icon-zoomin'
                     }
                     );
                     jqGridInvoperaciondetalle.jqGrid('navButtonAdd', '#jqGridInvoperaciondetallePager', {
                         id: 'pager_plus',
                         caption: '',
                         title: 'Agregar',
                         onClickButton: function (e) {
                             var emptyItem = [{iddetalle:"",unidadesrecividas:"",fovialoperacion:"",lotedetalle:"",preciocompra:"",precioorigen:"",descuentodetalle:"",unidadesvendidas:"",ivadetalle:"",preciocif:"",preciopromedio:"",ubicacionfisica:"",precioventa:"",exenta:"",gravada:"",unidadesordenadas:"",isr:"",idoperacionDelegate:"",idoperacionDescriptionDelegate:"",idproductoDelegate:"",idproductoDescriptionDelegate:""}];
                             jqGridInvoperaciondetalle.addRowData("id", emptyItem);
                             jqGridInvoperaciondetalle.jqGrid('editRow', "", true);
                             jqGridInvoperaciondetalle.setSelection("", true);
                             $("#pager_plus").addClass("ui-state-disabled");
                             $("#pager_edit").addClass("ui-state-disabled");
                             $("#pager_cancel").removeClass("ui-state-disabled");
                             $("#pager_save").removeClass("ui-state-disabled");
                             selectrow = "";
                         },
                         buttonicon: 'ui-icon-plus'
                     });
                     
                     jqGridInvoperaciondetalle.jqGrid('navButtonAdd', '#jqGridInvoperaciondetallePager', {
                                 id: 'pager_edit',
                                 caption: '',
                                 title: 'Editar',
                                 onClickButton: function (e) {
                                      var selRowId = jqGridInvoperaciondetalle.jqGrid('getGridParam', 'selrow');
                                      if (selRowId == null) {
                                          swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                         return;
                                      }
                                    jqGridInvoperaciondetalle.jqGrid('editRow', selRowId, true);
                                    jqGridInvoperaciondetalle.setSelection(selRowId, true);
                                    $("#pager_plus").addClass("ui-state-disabled");
                                    $("#pager_edit").addClass("ui-state-disabled");
                                    $("#pager_cancel").removeClass("ui-state-disabled");
                                    $("#pager_save").removeClass("ui-state-disabled");
                                    selectrow = selRowId;
                                 },
                                 buttonicon: 'ui-icon ui-icon-pencil'
                             });
                     
                     jqGridInvoperaciondetalle.jqGrid('navButtonAdd', '#jqGridInvoperaciondetallePager',
                              {id: 'pager_delete', caption: '', title: 'eliminar',
                               onClickButton: function (e) {
                                  var selRowId = jqGridInvoperaciondetalle.jqGrid('getGridParam', 'selrow');
                     
                                  if (selRowId == null) {
                                      swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                      return;
                                  }
                                  var row = jqGridInvoperaciondetalle.jqGrid('getRowData', selRowId);
                     
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
                                                  url: '${pageContext.request.contextPath}/deleteInvoperaciondetalle',
                                                  type: "POST",
                                                  success: function (response) {
                                                     swal("Elimnado!", "Su registro se elimino exitosamente.", "success");
                                                     $("button[data-dismiss='modal']").click();
                                                     jqGridInvoperaciondetalle.trigger("reloadGrid");
                                                     return false;
                                                  },
                                                  error: function (x, e) {
                                                        alert("Ocurrio un error");
                                                  }
                                              });
                                         } else {
                                              swal("Cancelado", "Su petición ha sido cancelada.","error");
                                              $("button[data-dismiss='modal']").click();
                                         }
                                      });
                                 },
                                 buttonicon: 'ui-icon-trash'
                             }
                     );
                     jqGridInvoperaciondetalle.jqGrid('navButtonAdd', '#jqGridInvoperaciondetallePager',
                          {id: 'pager_save', caption: '', title: 'Guardar',
                              onClickButton: function (e) {
                          
                     
                              jqGridInvoperaciondetalle.jqGrid('saveRow', selectrow);
                              var row = jqGridInvoperaciondetalle.jqGrid('getRowData', selectrow);
                     
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
                                          url: '${pageContext.request.contextPath}/saveInvoperaciondetalle',
                                          type: "POST",
                                          success: function (response) {
                                              swal("Guardado!", "Su registro se guardo exitosamente.", "success");
                                              $("button[data-dismiss='modal']").click();
                                              jqGridInvoperaciondetalle.trigger("reloadGrid");
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
                      
                      jqGridInvoperaciondetalle.jqGrid('navButtonAdd', '#jqGridInvoperaciondetallePager',
                          {id: 'pager_cancel', caption: '', title: 'Cancelar',
                              onClickButton: function (e) {
                              reloadEditGrid();
                          },
                          buttonicon: 'ui-icon-cancel'
                          }
                      );
                     jqGridInvoperaciondetalle.jqGrid('navButtonAdd', '#jqGridInvoperaciondetallePager', {
                         id: 'pager_excel',
                         caption: '',
                         title: 'Export',
                         onClickButton: function (e) {
                              exportInvoperaciondetalleGrid();
                         },
                         buttonicon: 'ui-icon-calculator'
                     });
                     
                     function reloadEditGrid() {
                          $("#pager_plus").removeClass("ui-state-disabled");
                          $("#pager_edit").removeClass("ui-state-disabled");
                          $("#pager_save").addClass("ui-state-disabled");
                          $("#pager_cancel").addClass("ui-state-disabled");
                          if (selectrow == "") {
                              jqGridInvoperaciondetalle.jqGrid('delRowData', "");
                          } else {
                              jqGridInvoperaciondetalle.jqGrid('restoreRow', selectrow);
                          }
                          selectrow = "";
                     }
                      function exportInvoperaciondetalleGrid() 
{                          $('#filters').val(jqGridInvoperaciondetalle.jqGrid('getGridParam', 'postData').filters);
                          $('#jqGridInvoperaciondetalleGridParameters').submit();
                                 }
                     
                      $(window).on('resize', function () {
                          var width = $('.jqgrid-responsive').width();
                          jqGridInvoperaciondetalle.setGridWidth(width);
                      }).resize();
                     
                  });
               })(window, document, window.jQuery);
               </script>
                     
               <table id="jqGridInvoperaciondetalle"></table>
               <table id="jqGridInvoperaciondetallePager"></table>
               
               <form method="post" id="jqGridInvoperaciondetalleGridParameters" action="/exportInvoperaciondetalle"  target="_blank">
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
        <div id="modalInvoperaciondetalle" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formInvoperaciondetalle" action="${urlsaveInvoperaciondetalle}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDDETALLE</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="iddetalle" name="iddetalle"  required="true"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">UNIDADESRECIVIDAS</label>
                                         <div class="col-lg-10">

  id="unidadesrecividas" name="unidadesrecividas"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">FOVIALOPERACION</label>
                                         <div class="col-lg-10">

  id="fovialoperacion" name="fovialoperacion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">LOTEDETALLE</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="3" maxlength="25"   id="lotedetalle" name="lotedetalle"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">PRECIOCOMPRA</label>
                                         <div class="col-lg-10">

  id="preciocompra" name="preciocompra"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">PRECIOORIGEN</label>
                                         <div class="col-lg-10">

  id="precioorigen" name="precioorigen"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DESCUENTODETALLE</label>
                                         <div class="col-lg-10">

  id="descuentodetalle" name="descuentodetalle"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">UNIDADESVENDIDAS</label>
                                         <div class="col-lg-10">

  id="unidadesvendidas" name="unidadesvendidas"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IVADETALLE</label>
                                         <div class="col-lg-10">

  id="ivadetalle" name="ivadetalle"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">PRECIOCIF</label>
                                         <div class="col-lg-10">

  id="preciocif" name="preciocif"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">PRECIOPROMEDIO</label>
                                         <div class="col-lg-10">

  id="preciopromedio" name="preciopromedio"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">UBICACIONFISICA</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="11" maxlength="100"   id="ubicacionfisica" name="ubicacionfisica"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">PRECIOVENTA</label>
                                         <div class="col-lg-10">

  id="precioventa" name="precioventa"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">EXENTA</label>
                                         <div class="col-lg-10">

  id="exenta" name="exenta"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">GRAVADA</label>
                                         <div class="col-lg-10">

  id="gravada" name="gravada"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">UNIDADESORDENADAS</label>
                                         <div class="col-lg-10">

  id="unidadesordenadas" name="unidadesordenadas"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ISR</label>
                                         <div class="col-lg-10">

  id="isr" name="isr"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDOPERACION</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvoperacion"   id="invoperacionDelegate"  name="invoperacion.idoperacion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDPRODUCTO</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvproducto"   id="invproductoDelegate"  name="invproducto.idproducto"  readonly="true" />
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
        

