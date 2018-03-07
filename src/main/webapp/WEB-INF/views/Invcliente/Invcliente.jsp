<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridInvcliente" var="urlgridInvcliente" />
        <c:url value="/exportInvcliente" var="recordsExportUrlInvcliente" />
        <c:url value="/saveInvcliente" var="urlsaveInvcliente" />
        <c:url value="/deleteInvcliente" var="urldeleteInvcliente" />
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
                        <h3>Invcliente
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
<script type="text/javascript">
             (function(window, document, $, undefined){
                 var selectrow = 0;
                 $(function(){
                     var jqGridInvcliente = $("#jqGridInvcliente");
                     var formInvcliente = $("#formInvcliente");
                     var modalInvcliente = $("#modalInvcliente");
                    jqGridInvcliente.jqGrid({
                         url: '${pageContext.request.contextPath}/gridInvcliente',
                         datatype: "json",
                         colModel:[ 
                                                            { label: 'IDCLIENTE', name: 'idcliente', width: 50 ,align:'center',key: true, hidden: true}
                                   ,{ label: 'NOMBRECLIENTE', name: 'nombrecliente', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'DUICLIENTE', name: 'duicliente', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'NITCLIENTE', name: 'nitcliente', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'ESPERSONACLIENTE', name: 'espersonacliente', width: 50 ,align:'center',editable: true, edittype: "text",
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
                                   ,{ label: 'GIROCLIENTE', name: 'girocliente', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'CREDITOCLIENTE', name: 'creditocliente', width: 50 ,align:'center',editable: true, edittype: "text",
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
                                   ,{ label: 'REGISTROCLIENTE', name: 'registrocliente', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'DIASCREDITOCLIENTE', name: 'diascreditocliente', width: 50 ,align:'center',editable: true, edittype: "text",
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
                                   ,{ label: 'IDTIPOCLIENTE', name: 'invtipoclienteDelegate',hidden:true} 
                                   ,{ label: 'IDTIPOCLIENTE', name: 'invtipoclienteDescriptionDelegate',align:'center', width: 50,stype:"select", editable: true, edittype: "select",
                                           searchoptions: {
                                               dataUrl: '${pageContext.request.contextPath}/cbofilterInvtipocliente',
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
                         pager: "#jqGridInvclientePager"
                    });
                     
                    jqGridInvcliente.jqGrid('filterToolbar', {stringResult: true, searchOnEnter: true, defaultSearch: "cn"});
                     
                     jqGridInvcliente.jqGrid('navGrid', '#jqGridInvclientePager',
                         {edit: false, add: false, del: false, search: false},
                          {}, {}, {},
                          {// search
                              closeOnEscape: true,
                              multipleSearch: true,
                              closeAfterSearch: true
                      });
                     
                  jqGridInvcliente.jqGrid('navButtonAdd', '#jqGridInvclientePager',
                     {id: 'pager_preview', caption: '', title: 'agregar',
                          onClickButton: function (e) {
                              var row = jqGridInvcliente.jqGrid('getGridParam', 'selrow');
                              if (row != null) {
                                  var rowData = jqGridInvcliente.getRowData(row);
                                  populateForm(formInvcliente, rowData);
                                  $("#btnModalSubmit").prop('disabled', true);
                                  modalInvcliente.modal('toggle');
                              } else {
                                  swal("Advertencia", "Por favor seleccione una fila.", "warning");
                              }
                          },
                              buttonicon: 'ui-icon-zoomin'
                     }
                     );
                     jqGridInvcliente.jqGrid('navButtonAdd', '#jqGridInvclientePager', {
                         id: 'pager_plus',
                         caption: '',
                         title: 'Agregar',
                         onClickButton: function (e) {
                             var emptyItem = [{idcliente:"",nombrecliente:"",duicliente:"",nitcliente:"",espersonacliente:"",girocliente:"",creditocliente:"",registrocliente:"",diascreditocliente:"",idtipoclienteDelegate:"",idtipoclienteDescriptionDelegate:""}];
                             jqGridInvcliente.addRowData("id", emptyItem);
                             jqGridInvcliente.jqGrid('editRow', "", true);
                             jqGridInvcliente.setSelection("", true);
                             $("#pager_plus").addClass("ui-state-disabled");
                             $("#pager_edit").addClass("ui-state-disabled");
                             $("#pager_cancel").removeClass("ui-state-disabled");
                             $("#pager_save").removeClass("ui-state-disabled");
                             selectrow = "";
                         },
                         buttonicon: 'ui-icon-plus'
                     });
                     
                     jqGridInvcliente.jqGrid('navButtonAdd', '#jqGridInvclientePager', {
                                 id: 'pager_edit',
                                 caption: '',
                                 title: 'Editar',
                                 onClickButton: function (e) {
                                      var selRowId = jqGridInvcliente.jqGrid('getGridParam', 'selrow');
                                      if (selRowId == null) {
                                          swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                         return;
                                      }
                                    jqGridInvcliente.jqGrid('editRow', selRowId, true);
                                    jqGridInvcliente.setSelection(selRowId, true);
                                    $("#pager_plus").addClass("ui-state-disabled");
                                    $("#pager_edit").addClass("ui-state-disabled");
                                    $("#pager_cancel").removeClass("ui-state-disabled");
                                    $("#pager_save").removeClass("ui-state-disabled");
                                    selectrow = selRowId;
                                 },
                                 buttonicon: 'ui-icon ui-icon-pencil'
                             });
                     
                     jqGridInvcliente.jqGrid('navButtonAdd', '#jqGridInvclientePager',
                              {id: 'pager_delete', caption: '', title: 'eliminar',
                               onClickButton: function (e) {
                                  var selRowId = jqGridInvcliente.jqGrid('getGridParam', 'selrow');
                     
                                  if (selRowId == null) {
                                      swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                      return;
                                  }
                                  var row = jqGridInvcliente.jqGrid('getRowData', selRowId);
                     
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
                                                  url: '${pageContext.request.contextPath}/deleteInvcliente',
                                                  type: "POST",
                                                  success: function (response) {
                                                     swal("Elimnado!", "Su registro se elimino exitosamente.", "success");
                                                     $("button[data-dismiss='modal']").click();
                                                     jqGridInvcliente.trigger("reloadGrid");
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
                     jqGridInvcliente.jqGrid('navButtonAdd', '#jqGridInvclientePager',
                          {id: 'pager_save', caption: '', title: 'Guardar',
                              onClickButton: function (e) {
                          
                     
                              jqGridInvcliente.jqGrid('saveRow', selectrow);
                              var row = jqGridInvcliente.jqGrid('getRowData', selectrow);
                     
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
                                          url: '${pageContext.request.contextPath}/saveInvcliente',
                                          type: "POST",
                                          success: function (response) {
                                              swal("Guardado!", "Su registro se guardo exitosamente.", "success");
                                              $("button[data-dismiss='modal']").click();
                                              jqGridInvcliente.trigger("reloadGrid");
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
                      
                      jqGridInvcliente.jqGrid('navButtonAdd', '#jqGridInvclientePager',
                          {id: 'pager_cancel', caption: '', title: 'Cancelar',
                              onClickButton: function (e) {
                              reloadEditGrid();
                          },
                          buttonicon: 'ui-icon-cancel'
                          }
                      );
                     jqGridInvcliente.jqGrid('navButtonAdd', '#jqGridInvclientePager', {
                         id: 'pager_excel',
                         caption: '',
                         title: 'Export',
                         onClickButton: function (e) {
                              exportInvclienteGrid();
                         },
                         buttonicon: 'ui-icon-calculator'
                     });
                     
                     function reloadEditGrid() {
                          $("#pager_plus").removeClass("ui-state-disabled");
                          $("#pager_edit").removeClass("ui-state-disabled");
                          $("#pager_save").addClass("ui-state-disabled");
                          $("#pager_cancel").addClass("ui-state-disabled");
                          if (selectrow == "") {
                              jqGridInvcliente.jqGrid('delRowData', "");
                          } else {
                              jqGridInvcliente.jqGrid('restoreRow', selectrow);
                          }
                          selectrow = "";
                     }
                      function exportInvclienteGrid() 
{                          $('#filters').val(jqGridInvcliente.jqGrid('getGridParam', 'postData').filters);
                          $('#jqGridInvclienteGridParameters').submit();
                                 }
                     
                      $(window).on('resize', function () {
                          var width = $('.jqgrid-responsive').width();
                          jqGridInvcliente.setGridWidth(width);
                      }).resize();
                     
                  });
               })(window, document, window.jQuery);
               </script>
                     
               <table id="jqGridInvcliente"></table>
               <table id="jqGridInvclientePager"></table>
               
               <form method="post" id="jqGridInvclienteGridParameters" action="/exportInvcliente"  target="_blank">
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
        <div id="modalInvcliente" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formInvcliente" action="${urlsaveInvcliente}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDCLIENTE</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idcliente" name="idcliente"  required="true"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NOMBRECLIENTE</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="1" maxlength="100"   id="nombrecliente" name="nombrecliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DUICLIENTE</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="2" maxlength="10"   id="duicliente" name="duicliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NITCLIENTE</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="3" maxlength="17"   id="nitcliente" name="nitcliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ESPERSONACLIENTE</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="espersonacliente" name="espersonacliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">GIROCLIENTE</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="5" maxlength="100"   id="girocliente" name="girocliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">CREDITOCLIENTE</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="8" scale="2"   id="creditocliente" name="creditocliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">REGISTROCLIENTE</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="7" maxlength="25"   id="registrocliente" name="registrocliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DIASCREDITOCLIENTE</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="diascreditocliente" name="diascreditocliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDTIPOCLIENTE</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvtipocliente"   id="invtipoclienteDelegate"  name="invtipocliente.idtipocliente"  readonly="true" />
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
        

