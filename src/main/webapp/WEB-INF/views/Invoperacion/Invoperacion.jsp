<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridInvoperacion" var="urlgridInvoperacion" />
        <c:url value="/exportInvoperacion" var="recordsExportUrlInvoperacion" />
        <c:url value="/saveInvoperacion" var="urlsaveInvoperacion" />
        <c:url value="/deleteInvoperacion" var="urldeleteInvoperacion" />
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
                        <h3>Invoperacion
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
<script type="text/javascript">
             (function(window, document, $, undefined){
                 var selectrow = 0;
                 $(function(){
                     var jqGridInvoperacion = $("#jqGridInvoperacion");
                     var formInvoperacion = $("#formInvoperacion");
                     var modalInvoperacion = $("#modalInvoperacion");
                    jqGridInvoperacion.jqGrid({
                         url: '${pageContext.request.contextPath}/gridInvoperacion',
                         datatype: "json",
                         colModel:[ 
                                                            { label: 'IDOPERACION', name: 'idoperacion', width: 50 ,align:'center',key: true, hidden: true}
                                   ,{ label: 'FECHAENTREGA', name: 'fechaentrega', width: 50 ,align:'center', editable: true, edittype: "text", searchoptions: {
                                           dataInit: function (el) {
                                               $(el).keydown(function (e) {
                                                   if ($(this).val() == "__/__/____") {
                                                       $(this).val("");
                                                   }
                                               });
                                               $(el).mask("99/99/9999");
                                               $(el).datepicker({dateFormat: 'dd/mm/yy',
                                                   onSelect: function (dateText, inst) {
                                                       jqGridFechaentrega[0].triggerToolbar();
                                                   },
                                                   beforeShow: function (input, inst) {
                                                       setTimeout(function () {$(".ui-datepicker").css("z-index", 2000);}, 10);
                                                   }
                                               });
                                           }
                                       }
                                       , editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                               if (e.keyCode == 13)
                                                   return false;
                                               }}], "dataInit": function (el) {
                                           $(el).keydown(function (e) {
                                               if ($(this).val() == "__/__/____") {
                                                   $(this).val("");
                                               }
                                           });
                                           $(el).mask("99/99/9999");
                                           $("#datepicker").datepicker($.datepicker.regional[ "es" ]);
                                           $(el).datepicker({dateFormat: 'dd/mm/yy',beforeShow: function (input, inst) {
                                               setTimeout(function () {
                                               $(".ui-datepicker").css("z-index", 2000);
                                               }, 10);
                                           }});
                                       }}
                                   }
                                   ,{ label: 'NUMEROENVIOORDEN', name: 'numeroenvioorden', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'RECERVADOOPERACION', name: 'recervadooperacion', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'NUMEROORDENCOMPRA', name: 'numeroordencompra', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'FECHAOPERACION', name: 'fechaoperacion', width: 50 ,align:'center', editable: true, edittype: "text", searchoptions: {
                                           dataInit: function (el) {
                                               $(el).keydown(function (e) {
                                                   if ($(this).val() == "__/__/____") {
                                                       $(this).val("");
                                                   }
                                               });
                                               $(el).mask("99/99/9999");
                                               $(el).datepicker({dateFormat: 'dd/mm/yy',
                                                   onSelect: function (dateText, inst) {
                                                       jqGridFechaoperacion[0].triggerToolbar();
                                                   },
                                                   beforeShow: function (input, inst) {
                                                       setTimeout(function () {$(".ui-datepicker").css("z-index", 2000);}, 10);
                                                   }
                                               });
                                           }
                                       }
                                       , editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                               if (e.keyCode == 13)
                                                   return false;
                                               }}], "dataInit": function (el) {
                                           $(el).keydown(function (e) {
                                               if ($(this).val() == "__/__/____") {
                                                   $(this).val("");
                                               }
                                           });
                                           $(el).mask("99/99/9999");
                                           $("#datepicker").datepicker($.datepicker.regional[ "es" ]);
                                           $(el).datepicker({dateFormat: 'dd/mm/yy',beforeShow: function (input, inst) {
                                               setTimeout(function () {
                                               $(".ui-datepicker").css("z-index", 2000);
                                               }, 10);
                                           }});
                                       }}
                                   }
                                   ,{ label: 'NUMERODOCUMENTO', name: 'numerodocumento', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'ORDENENTREGADA', name: 'ordenentregada', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'ESTADOOPERACION', name: 'estadooperacion', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'FECHACONTABLEOPERACION', name: 'fechacontableoperacion', width: 50 ,align:'center', editable: true, edittype: "text", searchoptions: {
                                           dataInit: function (el) {
                                               $(el).keydown(function (e) {
                                                   if ($(this).val() == "__/__/____") {
                                                       $(this).val("");
                                                   }
                                               });
                                               $(el).mask("99/99/9999");
                                               $(el).datepicker({dateFormat: 'dd/mm/yy',
                                                   onSelect: function (dateText, inst) {
                                                       jqGridFechacontableoperacion[0].triggerToolbar();
                                                   },
                                                   beforeShow: function (input, inst) {
                                                       setTimeout(function () {$(".ui-datepicker").css("z-index", 2000);}, 10);
                                                   }
                                               });
                                           }
                                       }
                                       , editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                               if (e.keyCode == 13)
                                                   return false;
                                               }}], "dataInit": function (el) {
                                           $(el).keydown(function (e) {
                                               if ($(this).val() == "__/__/____") {
                                                   $(this).val("");
                                               }
                                           });
                                           $(el).mask("99/99/9999");
                                           $("#datepicker").datepicker($.datepicker.regional[ "es" ]);
                                           $(el).datepicker({dateFormat: 'dd/mm/yy',beforeShow: function (input, inst) {
                                               setTimeout(function () {
                                               $(".ui-datepicker").css("z-index", 2000);
                                               }, 10);
                                           }});
                                       }}
                                   }
                                   ,{ label: 'DIASCREDITOOPERACION', name: 'diascreditooperacion', width: 50 ,align:'center',editable: true, edittype: "text",
                                           editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                                           if (e.keyCode == 13 || e.keyCode == 27)
                                                               return false;
                                                         }}],
                                           dataInit: function (el) {
                                               $(el).inputmask("decimal", {
                                                   min: 1,
                                                   max: 1000000000,
                                                   groupSeparator: ",",
                                                   digits: 0,
                                                   autoGroup: true,
                                                   autoUnmask: true
                                                });
                                           }}
                                   }
                                   ,{ label: 'COMENTARIOSOPERACION', name: 'comentariosoperacion', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'FECHAIVAOPERACION', name: 'fechaivaoperacion', width: 50 ,align:'center', editable: true, edittype: "text", searchoptions: {
                                           dataInit: function (el) {
                                               $(el).keydown(function (e) {
                                                   if ($(this).val() == "__/__/____") {
                                                       $(this).val("");
                                                   }
                                               });
                                               $(el).mask("99/99/9999");
                                               $(el).datepicker({dateFormat: 'dd/mm/yy',
                                                   onSelect: function (dateText, inst) {
                                                       jqGridFechaivaoperacion[0].triggerToolbar();
                                                   },
                                                   beforeShow: function (input, inst) {
                                                       setTimeout(function () {$(".ui-datepicker").css("z-index", 2000);}, 10);
                                                   }
                                               });
                                           }
                                       }
                                       , editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                               if (e.keyCode == 13)
                                                   return false;
                                               }}], "dataInit": function (el) {
                                           $(el).keydown(function (e) {
                                               if ($(this).val() == "__/__/____") {
                                                   $(this).val("");
                                               }
                                           });
                                           $(el).mask("99/99/9999");
                                           $("#datepicker").datepicker($.datepicker.regional[ "es" ]);
                                           $(el).datepicker({dateFormat: 'dd/mm/yy',beforeShow: function (input, inst) {
                                               setTimeout(function () {
                                               $(".ui-datepicker").css("z-index", 2000);
                                               }, 10);
                                           }});
                                       }}
                                   }
                                   ,{ label: 'ORDENRECIBIDA', name: 'ordenrecibida', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'IDPROVEEDOR', name: 'invproveedorDelegate',hidden:true} 
                                   ,{ label: 'IDPROVEEDOR', name: 'invproveedorDescriptionDelegate',align:'center', width: 50,stype:"select", editable: true, edittype: "select",
                                           searchoptions: {
                                               dataUrl: '${pageContext.request.contextPath}/cbofilterInvproveedor',
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
                                   ,{ label: 'IDCLIENTE', name: 'invclienteDelegate',hidden:true} 
                                   ,{ label: 'IDCLIENTE', name: 'invclienteDescriptionDelegate',align:'center', width: 50,stype:"select", editable: true, edittype: "select",
                                           searchoptions: {
                                               dataUrl: '${pageContext.request.contextPath}/cbofilterInvcliente',
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
                                   ,{ label: 'IDTIPOOPERACIONES', name: 'invtipooperacionesDelegate',hidden:true} 
                                   ,{ label: 'IDTIPOOPERACIONES', name: 'invtipooperacionesDescriptionDelegate',align:'center', width: 50,stype:"select", editable: true, edittype: "select",
                                           searchoptions: {
                                               dataUrl: '${pageContext.request.contextPath}/cbofilterInvtipooperaciones',
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
                         pager: "#jqGridInvoperacionPager"
                    });
                     
                    jqGridInvoperacion.jqGrid('filterToolbar', {stringResult: true, searchOnEnter: true, defaultSearch: "cn"});
                     
                     jqGridInvoperacion.jqGrid('navGrid', '#jqGridInvoperacionPager',
                         {edit: false, add: false, del: false, search: false},
                          {}, {}, {},
                          {// search
                              closeOnEscape: true,
                              multipleSearch: true,
                              closeAfterSearch: true
                      });
                     
                  jqGridInvoperacion.jqGrid('navButtonAdd', '#jqGridInvoperacionPager',
                     {id: 'pager_preview', caption: '', title: 'agregar',
                          onClickButton: function (e) {
                              var row = jqGridInvoperacion.jqGrid('getGridParam', 'selrow');
                              if (row != null) {
                                  var rowData = jqGridInvoperacion.getRowData(row);
                                  populateForm(formInvoperacion, rowData);
                                  $("#btnModalSubmit").prop('disabled', true);
                                  modalInvoperacion.modal('toggle');
                              } else {
                                  swal("Advertencia", "Por favor seleccione una fila.", "warning");
                              }
                          },
                              buttonicon: 'ui-icon-zoomin'
                     }
                     );
                     jqGridInvoperacion.jqGrid('navButtonAdd', '#jqGridInvoperacionPager', {
                         id: 'pager_plus',
                         caption: '',
                         title: 'Agregar',
                         onClickButton: function (e) {
                             var emptyItem = [{idoperacion:"",fechaentrega:"",numeroenvioorden:"",recervadooperacion:"",numeroordencompra:"",fechaoperacion:"",numerodocumento:"",ordenentregada:"",estadooperacion:"",fechacontableoperacion:"",diascreditooperacion:"",comentariosoperacion:"",fechaivaoperacion:"",ordenrecibida:"",idproveedorDelegate:"",idproveedorDescriptionDelegate:"",idclienteDelegate:"",idclienteDescriptionDelegate:"",idtipooperacionesDelegate:"",idtipooperacionesDescriptionDelegate:""}];
                             jqGridInvoperacion.addRowData("id", emptyItem);
                             jqGridInvoperacion.jqGrid('editRow', "", true);
                             jqGridInvoperacion.setSelection("", true);
                             $("#pager_plus").addClass("ui-state-disabled");
                             $("#pager_edit").addClass("ui-state-disabled");
                             $("#pager_cancel").removeClass("ui-state-disabled");
                             $("#pager_save").removeClass("ui-state-disabled");
                             selectrow = "";
                         },
                         buttonicon: 'ui-icon-plus'
                     });
                     
                     jqGridInvoperacion.jqGrid('navButtonAdd', '#jqGridInvoperacionPager', {
                                 id: 'pager_edit',
                                 caption: '',
                                 title: 'Editar',
                                 onClickButton: function (e) {
                                      var selRowId = jqGridInvoperacion.jqGrid('getGridParam', 'selrow');
                                      if (selRowId == null) {
                                          swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                         return;
                                      }
                                    jqGridInvoperacion.jqGrid('editRow', selRowId, true);
                                    jqGridInvoperacion.setSelection(selRowId, true);
                                    $("#pager_plus").addClass("ui-state-disabled");
                                    $("#pager_edit").addClass("ui-state-disabled");
                                    $("#pager_cancel").removeClass("ui-state-disabled");
                                    $("#pager_save").removeClass("ui-state-disabled");
                                    selectrow = selRowId;
                                 },
                                 buttonicon: 'ui-icon ui-icon-pencil'
                             });
                     
                     jqGridInvoperacion.jqGrid('navButtonAdd', '#jqGridInvoperacionPager',
                              {id: 'pager_delete', caption: '', title: 'eliminar',
                               onClickButton: function (e) {
                                  var selRowId = jqGridInvoperacion.jqGrid('getGridParam', 'selrow');
                     
                                  if (selRowId == null) {
                                      swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                      return;
                                  }
                                  var row = jqGridInvoperacion.jqGrid('getRowData', selRowId);
                     
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
                                                  url: '${pageContext.request.contextPath}/deleteInvoperacion',
                                                  type: "POST",
                                                  success: function (response) {
                                                     swal("Elimnado!", "Su registro se elimino exitosamente.", "success");
                                                     $("button[data-dismiss='modal']").click();
                                                     jqGridInvoperacion.trigger("reloadGrid");
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
                     jqGridInvoperacion.jqGrid('navButtonAdd', '#jqGridInvoperacionPager',
                          {id: 'pager_save', caption: '', title: 'Guardar',
                              onClickButton: function (e) {
                          
                     
                              jqGridInvoperacion.jqGrid('saveRow', selectrow);
                              var row = jqGridInvoperacion.jqGrid('getRowData', selectrow);
                     
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
                                          url: '${pageContext.request.contextPath}/saveInvoperacion',
                                          type: "POST",
                                          success: function (response) {
                                              swal("Guardado!", "Su registro se guardo exitosamente.", "success");
                                              $("button[data-dismiss='modal']").click();
                                              jqGridInvoperacion.trigger("reloadGrid");
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
                      
                      jqGridInvoperacion.jqGrid('navButtonAdd', '#jqGridInvoperacionPager',
                          {id: 'pager_cancel', caption: '', title: 'Cancelar',
                              onClickButton: function (e) {
                              reloadEditGrid();
                          },
                          buttonicon: 'ui-icon-cancel'
                          }
                      );
                     jqGridInvoperacion.jqGrid('navButtonAdd', '#jqGridInvoperacionPager', {
                         id: 'pager_excel',
                         caption: '',
                         title: 'Export',
                         onClickButton: function (e) {
                              exportInvoperacionGrid();
                         },
                         buttonicon: 'ui-icon-calculator'
                     });
                     
                     function reloadEditGrid() {
                          $("#pager_plus").removeClass("ui-state-disabled");
                          $("#pager_edit").removeClass("ui-state-disabled");
                          $("#pager_save").addClass("ui-state-disabled");
                          $("#pager_cancel").addClass("ui-state-disabled");
                          if (selectrow == "") {
                              jqGridInvoperacion.jqGrid('delRowData', "");
                          } else {
                              jqGridInvoperacion.jqGrid('restoreRow', selectrow);
                          }
                          selectrow = "";
                     }
                      function exportInvoperacionGrid() 
{                          $('#filters').val(jqGridInvoperacion.jqGrid('getGridParam', 'postData').filters);
                          $('#jqGridInvoperacionGridParameters').submit();
                                 }
                     
                      $(window).on('resize', function () {
                          var width = $('.jqgrid-responsive').width();
                          jqGridInvoperacion.setGridWidth(width);
                      }).resize();
                     
                  });
               })(window, document, window.jQuery);
               </script>
                     
               <table id="jqGridInvoperacion"></table>
               <table id="jqGridInvoperacionPager"></table>
               
               <form method="post" id="jqGridInvoperacionGridParameters" action="/exportInvoperacion"  target="_blank">
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
        <div id="modalInvoperacion" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formInvoperacion" action="${urlsaveInvoperacion}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDOPERACION</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idoperacion" name="idoperacion"  required="true"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">FECHAENTREGA</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="1"   id="fechaentrega" name="fechaentrega"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NUMEROENVIOORDEN</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="2" maxlength="10"   id="numeroenvioorden" name="numeroenvioorden"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">RECERVADOOPERACION</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="3" maxlength="2"   id="recervadooperacion" name="recervadooperacion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NUMEROORDENCOMPRA</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="4" maxlength="10"   id="numeroordencompra" name="numeroordencompra"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">FECHAOPERACION</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="5"   id="fechaoperacion" name="fechaoperacion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NUMERODOCUMENTO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="6" maxlength="10"   id="numerodocumento" name="numerodocumento"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ORDENENTREGADA</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="7" maxlength="2"   id="ordenentregada" name="ordenentregada"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ESTADOOPERACION</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="8" maxlength="2"   id="estadooperacion" name="estadooperacion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">FECHACONTABLEOPERACION</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="9"   id="fechacontableoperacion" name="fechacontableoperacion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DIASCREDITOOPERACION</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="diascreditooperacion" name="diascreditooperacion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">COMENTARIOSOPERACION</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="11" maxlength="100"   id="comentariosoperacion" name="comentariosoperacion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">FECHAIVAOPERACION</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="12"   id="fechaivaoperacion" name="fechaivaoperacion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ORDENRECIBIDA</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="13" maxlength="2"   id="ordenrecibida" name="ordenrecibida"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDPROVEEDOR</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvproveedor"   id="invproveedorDelegate"  name="invproveedor.idproveedor"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDCLIENTE</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvcliente"   id="invclienteDelegate"  name="invcliente.idcliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDTIPOOPERACIONES</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvtipooperaciones"   id="invtipooperacionesDelegate"  name="invtipooperaciones.idtipooperaciones"  readonly="true" />
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
        

