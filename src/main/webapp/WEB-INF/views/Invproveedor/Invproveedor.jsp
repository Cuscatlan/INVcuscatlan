<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridInvproveedor" var="urlgridInvproveedor" />
        <c:url value="/exportInvproveedor" var="recordsExportUrlInvproveedor" />
        <c:url value="/saveInvproveedor" var="urlsaveInvproveedor" />
        <c:url value="/deleteInvproveedor" var="urldeleteInvproveedor" />
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
                        <h3>Invproveedor
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
<script type="text/javascript">
             (function(window, document, $, undefined){
                 var selectrow = 0;
                 $(function(){
                     var jqGridInvproveedor = $("#jqGridInvproveedor");
                     var formInvproveedor = $("#formInvproveedor");
                     var modalInvproveedor = $("#modalInvproveedor");
                    jqGridInvproveedor.jqGrid({
                         url: '${pageContext.request.contextPath}/gridInvproveedor',
                         datatype: "json",
                         colModel:[ 
                                                            { label: 'IDPROVEEDOR', name: 'idproveedor', width: 50 ,align:'center',key: true, hidden: true}
                                   ,{ label: 'NOMBREPROVEEDOR', name: 'nombreproveedor', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'CONTACTOPROVEEDOR', name: 'contactoproveedor', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'REGISTROPROVEEDOR', name: 'registroproveedor', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'ESPERSONAPROVEEDOR', name: 'espersonaproveedor', width: 50 ,align:'center',editable: true, edittype: "text",
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
                                   ,{ label: 'GIROPROVEEDOR', name: 'giroproveedor', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'NITPROVEEDOR', name: 'nitproveedor', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'TIPOCONTRIBUYENTEPROVEEDOR', name: 'tipocontribuyenteproveedor', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'DUIPROVEEDOR', name: 'duiproveedor', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
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
                         pager: "#jqGridInvproveedorPager"
                    });
                     
                    jqGridInvproveedor.jqGrid('filterToolbar', {stringResult: true, searchOnEnter: true, defaultSearch: "cn"});
                     
                     jqGridInvproveedor.jqGrid('navGrid', '#jqGridInvproveedorPager',
                         {edit: false, add: false, del: false, search: false},
                          {}, {}, {},
                          {// search
                              closeOnEscape: true,
                              multipleSearch: true,
                              closeAfterSearch: true
                      });
                     
                  jqGridInvproveedor.jqGrid('navButtonAdd', '#jqGridInvproveedorPager',
                     {id: 'pager_preview', caption: '', title: 'agregar',
                          onClickButton: function (e) {
                              var row = jqGridInvproveedor.jqGrid('getGridParam', 'selrow');
                              if (row != null) {
                                  var rowData = jqGridInvproveedor.getRowData(row);
                                  populateForm(formInvproveedor, rowData);
                                  $("#btnModalSubmit").prop('disabled', true);
                                  modalInvproveedor.modal('toggle');
                              } else {
                                  swal("Advertencia", "Por favor seleccione una fila.", "warning");
                              }
                          },
                              buttonicon: 'ui-icon-zoomin'
                     }
                     );
                     jqGridInvproveedor.jqGrid('navButtonAdd', '#jqGridInvproveedorPager', {
                         id: 'pager_plus',
                         caption: '',
                         title: 'Agregar',
                         onClickButton: function (e) {
                             var emptyItem = [{idproveedor:"",nombreproveedor:"",contactoproveedor:"",registroproveedor:"",espersonaproveedor:"",giroproveedor:"",nitproveedor:"",tipocontribuyenteproveedor:"",duiproveedor:""}];
                             jqGridInvproveedor.addRowData("id", emptyItem);
                             jqGridInvproveedor.jqGrid('editRow', "", true);
                             jqGridInvproveedor.setSelection("", true);
                             $("#pager_plus").addClass("ui-state-disabled");
                             $("#pager_edit").addClass("ui-state-disabled");
                             $("#pager_cancel").removeClass("ui-state-disabled");
                             $("#pager_save").removeClass("ui-state-disabled");
                             selectrow = "";
                         },
                         buttonicon: 'ui-icon-plus'
                     });
                     
                     jqGridInvproveedor.jqGrid('navButtonAdd', '#jqGridInvproveedorPager', {
                                 id: 'pager_edit',
                                 caption: '',
                                 title: 'Editar',
                                 onClickButton: function (e) {
                                      var selRowId = jqGridInvproveedor.jqGrid('getGridParam', 'selrow');
                                      if (selRowId == null) {
                                          swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                         return;
                                      }
                                    jqGridInvproveedor.jqGrid('editRow', selRowId, true);
                                    jqGridInvproveedor.setSelection(selRowId, true);
                                    $("#pager_plus").addClass("ui-state-disabled");
                                    $("#pager_edit").addClass("ui-state-disabled");
                                    $("#pager_cancel").removeClass("ui-state-disabled");
                                    $("#pager_save").removeClass("ui-state-disabled");
                                    selectrow = selRowId;
                                 },
                                 buttonicon: 'ui-icon ui-icon-pencil'
                             });
                     
                     jqGridInvproveedor.jqGrid('navButtonAdd', '#jqGridInvproveedorPager',
                              {id: 'pager_delete', caption: '', title: 'eliminar',
                               onClickButton: function (e) {
                                  var selRowId = jqGridInvproveedor.jqGrid('getGridParam', 'selrow');
                     
                                  if (selRowId == null) {
                                      swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                      return;
                                  }
                                  var row = jqGridInvproveedor.jqGrid('getRowData', selRowId);
                     
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
                                                  url: '${pageContext.request.contextPath}/deleteInvproveedor',
                                                  type: "POST",
                                                  success: function (response) {
                                                     swal("Elimnado!", "Su registro se elimino exitosamente.", "success");
                                                     $("button[data-dismiss='modal']").click();
                                                     jqGridInvproveedor.trigger("reloadGrid");
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
                     jqGridInvproveedor.jqGrid('navButtonAdd', '#jqGridInvproveedorPager',
                          {id: 'pager_save', caption: '', title: 'Guardar',
                              onClickButton: function (e) {
                          
                     
                              jqGridInvproveedor.jqGrid('saveRow', selectrow);
                              var row = jqGridInvproveedor.jqGrid('getRowData', selectrow);
                     
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
                                          url: '${pageContext.request.contextPath}/saveInvproveedor',
                                          type: "POST",
                                          success: function (response) {
                                              swal("Guardado!", "Su registro se guardo exitosamente.", "success");
                                              $("button[data-dismiss='modal']").click();
                                              jqGridInvproveedor.trigger("reloadGrid");
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
                      
                      jqGridInvproveedor.jqGrid('navButtonAdd', '#jqGridInvproveedorPager',
                          {id: 'pager_cancel', caption: '', title: 'Cancelar',
                              onClickButton: function (e) {
                              reloadEditGrid();
                          },
                          buttonicon: 'ui-icon-cancel'
                          }
                      );
                     jqGridInvproveedor.jqGrid('navButtonAdd', '#jqGridInvproveedorPager', {
                         id: 'pager_excel',
                         caption: '',
                         title: 'Export',
                         onClickButton: function (e) {
                              exportInvproveedorGrid();
                         },
                         buttonicon: 'ui-icon-calculator'
                     });
                     
                     function reloadEditGrid() {
                          $("#pager_plus").removeClass("ui-state-disabled");
                          $("#pager_edit").removeClass("ui-state-disabled");
                          $("#pager_save").addClass("ui-state-disabled");
                          $("#pager_cancel").addClass("ui-state-disabled");
                          if (selectrow == "") {
                              jqGridInvproveedor.jqGrid('delRowData', "");
                          } else {
                              jqGridInvproveedor.jqGrid('restoreRow', selectrow);
                          }
                          selectrow = "";
                     }
                      function exportInvproveedorGrid() 
{                          $('#filters').val(jqGridInvproveedor.jqGrid('getGridParam', 'postData').filters);
                          $('#jqGridInvproveedorGridParameters').submit();
                                 }
                     
                      $(window).on('resize', function () {
                          var width = $('.jqgrid-responsive').width();
                          jqGridInvproveedor.setGridWidth(width);
                      }).resize();
                     
                  });
               })(window, document, window.jQuery);
               </script>
                     
               <table id="jqGridInvproveedor"></table>
               <table id="jqGridInvproveedorPager"></table>
               
               <form method="post" id="jqGridInvproveedorGridParameters" action="/exportInvproveedor"  target="_blank">
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
        <div id="modalInvproveedor" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formInvproveedor" action="${urlsaveInvproveedor}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDPROVEEDOR</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idproveedor" name="idproveedor"  required="true"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NOMBREPROVEEDOR</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="1" maxlength="50"   id="nombreproveedor" name="nombreproveedor"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">CONTACTOPROVEEDOR</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="2" maxlength="50"   id="contactoproveedor" name="contactoproveedor"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">REGISTROPROVEEDOR</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="3" maxlength="25"   id="registroproveedor" name="registroproveedor"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ESPERSONAPROVEEDOR</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="espersonaproveedor" name="espersonaproveedor"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">GIROPROVEEDOR</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="5" maxlength="100"   id="giroproveedor" name="giroproveedor"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NITPROVEEDOR</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="6" maxlength="17"   id="nitproveedor" name="nitproveedor"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">TIPOCONTRIBUYENTEPROVEEDOR</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="7" maxlength="10"   id="tipocontribuyenteproveedor" name="tipocontribuyenteproveedor"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DUIPROVEEDOR</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="8" maxlength="10"   id="duiproveedor" name="duiproveedor"  readonly="true" />
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
        

