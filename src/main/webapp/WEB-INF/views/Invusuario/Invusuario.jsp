<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridInvusuario" var="urlgridInvusuario" />
        <c:url value="/exportInvusuario" var="recordsExportUrlInvusuario" />
        <c:url value="/saveInvusuario" var="urlsaveInvusuario" />
        <c:url value="/deleteInvusuario" var="urldeleteInvusuario" />
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
                        <h3>Invusuario
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
<script type="text/javascript">
             (function(window, document, $, undefined){
                 var selectrow = 0;
                 $(function(){
                     var jqGridInvusuario = $("#jqGridInvusuario");
                     var formInvusuario = $("#formInvusuario");
                     var modalInvusuario = $("#modalInvusuario");
                    jqGridInvusuario.jqGrid({
                         url: '${pageContext.request.contextPath}/gridInvusuario',
                         datatype: "json",
                         colModel:[ 
                                                            { label: 'IDUSUARIO', name: 'idusuario', width: 50 ,align:'center',key: true, hidden: true}
                                   ,{ label: 'NOMBREUSUARIO', name: 'nombreusuario', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'DUIUSUARIO', name: 'duiusuario', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'CLAVEUSUARIO', name: 'claveusuario', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'CORREOUSUARIO', name: 'correousuario', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'PROFECIONUSUARIO', name: 'profecionusuario', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'IDTIPOUSUARIO', name: 'invtipousuarioDelegate',hidden:true} 
                                   ,{ label: 'IDTIPOUSUARIO', name: 'invtipousuarioDescriptionDelegate',align:'center', width: 50,stype:"select", editable: true, edittype: "select",
                                           searchoptions: {
                                               dataUrl: '${pageContext.request.contextPath}/cbofilterInvtipousuario',
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
                         pager: "#jqGridInvusuarioPager"
                    });
                     
                    jqGridInvusuario.jqGrid('filterToolbar', {stringResult: true, searchOnEnter: true, defaultSearch: "cn"});
                     
                     jqGridInvusuario.jqGrid('navGrid', '#jqGridInvusuarioPager',
                         {edit: false, add: false, del: false, search: false},
                          {}, {}, {},
                          {// search
                              closeOnEscape: true,
                              multipleSearch: true,
                              closeAfterSearch: true
                      });
                     
                  jqGridInvusuario.jqGrid('navButtonAdd', '#jqGridInvusuarioPager',
                     {id: 'pager_preview', caption: '', title: 'agregar',
                          onClickButton: function (e) {
                              var row = jqGridInvusuario.jqGrid('getGridParam', 'selrow');
                              if (row != null) {
                                  var rowData = jqGridInvusuario.getRowData(row);
                                  populateForm(formInvusuario, rowData);
                                  $("#btnModalSubmit").prop('disabled', true);
                                  modalInvusuario.modal('toggle');
                              } else {
                                  swal("Advertencia", "Por favor seleccione una fila.", "warning");
                              }
                          },
                              buttonicon: 'ui-icon-zoomin'
                     }
                     );
                     jqGridInvusuario.jqGrid('navButtonAdd', '#jqGridInvusuarioPager', {
                         id: 'pager_plus',
                         caption: '',
                         title: 'Agregar',
                         onClickButton: function (e) {
                             var emptyItem = [{idusuario:"",nombreusuario:"",duiusuario:"",claveusuario:"",correousuario:"",profecionusuario:"",idtipousuarioDelegate:"",idtipousuarioDescriptionDelegate:""}];
                             jqGridInvusuario.addRowData("id", emptyItem);
                             jqGridInvusuario.jqGrid('editRow', "", true);
                             jqGridInvusuario.setSelection("", true);
                             $("#pager_plus").addClass("ui-state-disabled");
                             $("#pager_edit").addClass("ui-state-disabled");
                             $("#pager_cancel").removeClass("ui-state-disabled");
                             $("#pager_save").removeClass("ui-state-disabled");
                             selectrow = "";
                         },
                         buttonicon: 'ui-icon-plus'
                     });
                     
                     jqGridInvusuario.jqGrid('navButtonAdd', '#jqGridInvusuarioPager', {
                                 id: 'pager_edit',
                                 caption: '',
                                 title: 'Editar',
                                 onClickButton: function (e) {
                                      var selRowId = jqGridInvusuario.jqGrid('getGridParam', 'selrow');
                                      if (selRowId == null) {
                                          swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                         return;
                                      }
                                    jqGridInvusuario.jqGrid('editRow', selRowId, true);
                                    jqGridInvusuario.setSelection(selRowId, true);
                                    $("#pager_plus").addClass("ui-state-disabled");
                                    $("#pager_edit").addClass("ui-state-disabled");
                                    $("#pager_cancel").removeClass("ui-state-disabled");
                                    $("#pager_save").removeClass("ui-state-disabled");
                                    selectrow = selRowId;
                                 },
                                 buttonicon: 'ui-icon ui-icon-pencil'
                             });
                     
                     jqGridInvusuario.jqGrid('navButtonAdd', '#jqGridInvusuarioPager',
                              {id: 'pager_delete', caption: '', title: 'eliminar',
                               onClickButton: function (e) {
                                  var selRowId = jqGridInvusuario.jqGrid('getGridParam', 'selrow');
                     
                                  if (selRowId == null) {
                                      swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                      return;
                                  }
                                  var row = jqGridInvusuario.jqGrid('getRowData', selRowId);
                     
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
                                                  url: '${pageContext.request.contextPath}/deleteInvusuario',
                                                  type: "POST",
                                                  success: function (response) {
                                                     swal("Elimnado!", "Su registro se elimino exitosamente.", "success");
                                                     $("button[data-dismiss='modal']").click();
                                                     jqGridInvusuario.trigger("reloadGrid");
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
                     jqGridInvusuario.jqGrid('navButtonAdd', '#jqGridInvusuarioPager',
                          {id: 'pager_save', caption: '', title: 'Guardar',
                              onClickButton: function (e) {
                          
                     
                              jqGridInvusuario.jqGrid('saveRow', selectrow);
                              var row = jqGridInvusuario.jqGrid('getRowData', selectrow);
                     
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
                                          url: '${pageContext.request.contextPath}/saveInvusuario',
                                          type: "POST",
                                          success: function (response) {
                                              swal("Guardado!", "Su registro se guardo exitosamente.", "success");
                                              $("button[data-dismiss='modal']").click();
                                              jqGridInvusuario.trigger("reloadGrid");
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
                      
                      jqGridInvusuario.jqGrid('navButtonAdd', '#jqGridInvusuarioPager',
                          {id: 'pager_cancel', caption: '', title: 'Cancelar',
                              onClickButton: function (e) {
                              reloadEditGrid();
                          },
                          buttonicon: 'ui-icon-cancel'
                          }
                      );
                     jqGridInvusuario.jqGrid('navButtonAdd', '#jqGridInvusuarioPager', {
                         id: 'pager_excel',
                         caption: '',
                         title: 'Export',
                         onClickButton: function (e) {
                              exportInvusuarioGrid();
                         },
                         buttonicon: 'ui-icon-calculator'
                     });
                     
                     function reloadEditGrid() {
                          $("#pager_plus").removeClass("ui-state-disabled");
                          $("#pager_edit").removeClass("ui-state-disabled");
                          $("#pager_save").addClass("ui-state-disabled");
                          $("#pager_cancel").addClass("ui-state-disabled");
                          if (selectrow == "") {
                              jqGridInvusuario.jqGrid('delRowData', "");
                          } else {
                              jqGridInvusuario.jqGrid('restoreRow', selectrow);
                          }
                          selectrow = "";
                     }
                      function exportInvusuarioGrid() 
{                          $('#filters').val(jqGridInvusuario.jqGrid('getGridParam', 'postData').filters);
                          $('#jqGridInvusuarioGridParameters').submit();
                                 }
                     
                      $(window).on('resize', function () {
                          var width = $('.jqgrid-responsive').width();
                          jqGridInvusuario.setGridWidth(width);
                      }).resize();
                     
                  });
               })(window, document, window.jQuery);
               </script>
                     
               <table id="jqGridInvusuario"></table>
               <table id="jqGridInvusuarioPager"></table>
               
               <form method="post" id="jqGridInvusuarioGridParameters" action="/exportInvusuario"  target="_blank">
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
        <div id="modalInvusuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formInvusuario" action="${urlsaveInvusuario}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDUSUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idusuario" name="idusuario"  required="true"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NOMBREUSUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="1" maxlength="50"   id="nombreusuario" name="nombreusuario"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DUIUSUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="2" maxlength="10"   id="duiusuario" name="duiusuario"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">CLAVEUSUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="3" maxlength="100"   id="claveusuario" name="claveusuario"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">CORREOUSUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="4" maxlength="50"   id="correousuario" name="correousuario"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">PROFECIONUSUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="5" maxlength="10"   id="profecionusuario" name="profecionusuario"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDTIPOUSUARIO</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvtipousuario"   id="invtipousuarioDelegate"  name="invtipousuario.idtipousuario"  readonly="true" />
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
        

