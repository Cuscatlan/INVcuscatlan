<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridInvfamiliaproducto" var="urlgridInvfamiliaproducto" />
        <c:url value="/exportInvfamiliaproducto" var="recordsExportUrlInvfamiliaproducto" />
        <c:url value="/saveInvfamiliaproducto" var="urlsaveInvfamiliaproducto" />
        <c:url value="/deleteInvfamiliaproducto" var="urldeleteInvfamiliaproducto" />
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
                        <h3>Invfamiliaproducto
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
<script type="text/javascript">
             (function(window, document, $, undefined){
                 var selectrow = 0;
                 $(function(){
                     var jqGridInvfamiliaproducto = $("#jqGridInvfamiliaproducto");
                     var formInvfamiliaproducto = $("#formInvfamiliaproducto");
                     var modalInvfamiliaproducto = $("#modalInvfamiliaproducto");
                    jqGridInvfamiliaproducto.jqGrid({
                         url: '${pageContext.request.contextPath}/gridInvfamiliaproducto',
                         datatype: "json",
                         colModel:[ 
                                                            { label: 'IDFAMILIAPRODUCTO', name: 'idfamiliaproducto', width: 50 ,align:'center',key: true, hidden: true}
                                   ,{ label: 'ESTADOFAMILIAPRODUCTO', name: 'estadofamiliaproducto', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'NOMBREFAMILIAPRODUCTO', name: 'nombrefamiliaproducto', width: 50 ,align:'center', editable: true, edittype: "text",                                       editoptions: {dataEvents: [{type: "keydown", fn: function (e) {
                                           if (e.keyCode == 13 || e.keyCode == 27)
                                               return false;
                                        }}]}
                                   }
                                   ,{ label: 'IDGRUPOPRODUCTO', name: 'idgrupoproducto', width: 50 ,align:'center',editable: true, edittype: "text",
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
                         pager: "#jqGridInvfamiliaproductoPager"
                    });
                     
                    jqGridInvfamiliaproducto.jqGrid('filterToolbar', {stringResult: true, searchOnEnter: true, defaultSearch: "cn"});
                     
                     jqGridInvfamiliaproducto.jqGrid('navGrid', '#jqGridInvfamiliaproductoPager',
                         {edit: false, add: false, del: false, search: false},
                          {}, {}, {},
                          {// search
                              closeOnEscape: true,
                              multipleSearch: true,
                              closeAfterSearch: true
                      });
                     
                  jqGridInvfamiliaproducto.jqGrid('navButtonAdd', '#jqGridInvfamiliaproductoPager',
                     {id: 'pager_preview', caption: '', title: 'agregar',
                          onClickButton: function (e) {
                              var row = jqGridInvfamiliaproducto.jqGrid('getGridParam', 'selrow');
                              if (row != null) {
                                  var rowData = jqGridInvfamiliaproducto.getRowData(row);
                                  populateForm(formInvfamiliaproducto, rowData);
                                  $("#btnModalSubmit").prop('disabled', true);
                                  modalInvfamiliaproducto.modal('toggle');
                              } else {
                                  swal("Advertencia", "Por favor seleccione una fila.", "warning");
                              }
                          },
                              buttonicon: 'ui-icon-zoomin'
                     }
                     );
                     jqGridInvfamiliaproducto.jqGrid('navButtonAdd', '#jqGridInvfamiliaproductoPager', {
                         id: 'pager_plus',
                         caption: '',
                         title: 'Agregar',
                         onClickButton: function (e) {
                             var emptyItem = [{idfamiliaproducto:"",estadofamiliaproducto:"",nombrefamiliaproducto:"",idgrupoproducto:""}];
                             jqGridInvfamiliaproducto.addRowData("id", emptyItem);
                             jqGridInvfamiliaproducto.jqGrid('editRow', "", true);
                             jqGridInvfamiliaproducto.setSelection("", true);
                             $("#pager_plus").addClass("ui-state-disabled");
                             $("#pager_edit").addClass("ui-state-disabled");
                             $("#pager_cancel").removeClass("ui-state-disabled");
                             $("#pager_save").removeClass("ui-state-disabled");
                             selectrow = "";
                         },
                         buttonicon: 'ui-icon-plus'
                     });
                     
                     jqGridInvfamiliaproducto.jqGrid('navButtonAdd', '#jqGridInvfamiliaproductoPager', {
                                 id: 'pager_edit',
                                 caption: '',
                                 title: 'Editar',
                                 onClickButton: function (e) {
                                      var selRowId = jqGridInvfamiliaproducto.jqGrid('getGridParam', 'selrow');
                                      if (selRowId == null) {
                                          swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                         return;
                                      }
                                    jqGridInvfamiliaproducto.jqGrid('editRow', selRowId, true);
                                    jqGridInvfamiliaproducto.setSelection(selRowId, true);
                                    $("#pager_plus").addClass("ui-state-disabled");
                                    $("#pager_edit").addClass("ui-state-disabled");
                                    $("#pager_cancel").removeClass("ui-state-disabled");
                                    $("#pager_save").removeClass("ui-state-disabled");
                                    selectrow = selRowId;
                                 },
                                 buttonicon: 'ui-icon ui-icon-pencil'
                             });
                     
                     jqGridInvfamiliaproducto.jqGrid('navButtonAdd', '#jqGridInvfamiliaproductoPager',
                              {id: 'pager_delete', caption: '', title: 'eliminar',
                               onClickButton: function (e) {
                                  var selRowId = jqGridInvfamiliaproducto.jqGrid('getGridParam', 'selrow');
                     
                                  if (selRowId == null) {
                                      swal("Advertencia", "Por favor seleccione una fila.", "warning");
                                      return;
                                  }
                                  var row = jqGridInvfamiliaproducto.jqGrid('getRowData', selRowId);
                     
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
                                                  url: '${pageContext.request.contextPath}/deleteInvfamiliaproducto',
                                                  type: "POST",
                                                  success: function (response) {
                                                     swal("Elimnado!", "Su registro se elimino exitosamente.", "success");
                                                     $("button[data-dismiss='modal']").click();
                                                     jqGridInvfamiliaproducto.trigger("reloadGrid");
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
                     jqGridInvfamiliaproducto.jqGrid('navButtonAdd', '#jqGridInvfamiliaproductoPager',
                          {id: 'pager_save', caption: '', title: 'Guardar',
                              onClickButton: function (e) {
                          
                     
                              jqGridInvfamiliaproducto.jqGrid('saveRow', selectrow);
                              var row = jqGridInvfamiliaproducto.jqGrid('getRowData', selectrow);
                     
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
                                          url: '${pageContext.request.contextPath}/saveInvfamiliaproducto',
                                          type: "POST",
                                          success: function (response) {
                                              swal("Guardado!", "Su registro se guardo exitosamente.", "success");
                                              $("button[data-dismiss='modal']").click();
                                              jqGridInvfamiliaproducto.trigger("reloadGrid");
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
                      
                      jqGridInvfamiliaproducto.jqGrid('navButtonAdd', '#jqGridInvfamiliaproductoPager',
                          {id: 'pager_cancel', caption: '', title: 'Cancelar',
                              onClickButton: function (e) {
                              reloadEditGrid();
                          },
                          buttonicon: 'ui-icon-cancel'
                          }
                      );
                     jqGridInvfamiliaproducto.jqGrid('navButtonAdd', '#jqGridInvfamiliaproductoPager', {
                         id: 'pager_excel',
                         caption: '',
                         title: 'Export',
                         onClickButton: function (e) {
                              exportInvfamiliaproductoGrid();
                         },
                         buttonicon: 'ui-icon-calculator'
                     });
                     
                     function reloadEditGrid() {
                          $("#pager_plus").removeClass("ui-state-disabled");
                          $("#pager_edit").removeClass("ui-state-disabled");
                          $("#pager_save").addClass("ui-state-disabled");
                          $("#pager_cancel").addClass("ui-state-disabled");
                          if (selectrow == "") {
                              jqGridInvfamiliaproducto.jqGrid('delRowData', "");
                          } else {
                              jqGridInvfamiliaproducto.jqGrid('restoreRow', selectrow);
                          }
                          selectrow = "";
                     }
                      function exportInvfamiliaproductoGrid() 
{                          $('#filters').val(jqGridInvfamiliaproducto.jqGrid('getGridParam', 'postData').filters);
                          $('#jqGridInvfamiliaproductoGridParameters').submit();
                                 }
                     
                      $(window).on('resize', function () {
                          var width = $('.jqgrid-responsive').width();
                          jqGridInvfamiliaproducto.setGridWidth(width);
                      }).resize();
                     
                  });
               })(window, document, window.jQuery);
               </script>
                     
               <table id="jqGridInvfamiliaproducto"></table>
               <table id="jqGridInvfamiliaproductoPager"></table>
               
               <form method="post" id="jqGridInvfamiliaproductoGridParameters" action="/exportInvfamiliaproducto"  target="_blank">
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
        <div id="modalInvfamiliaproducto" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formInvfamiliaproducto" action="${urlsaveInvfamiliaproducto}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDFAMILIAPRODUCTO</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idfamiliaproducto" name="idfamiliaproducto"  required="true"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ESTADOFAMILIAPRODUCTO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="1" maxlength="2"   id="estadofamiliaproducto" name="estadofamiliaproducto"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NOMBREFAMILIAPRODUCTO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="2" maxlength="50"   id="nombrefamiliaproducto" name="nombrefamiliaproducto"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDGRUPOPRODUCTO</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idgrupoproducto" name="idgrupoproducto"  readonly="true" />
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
        

