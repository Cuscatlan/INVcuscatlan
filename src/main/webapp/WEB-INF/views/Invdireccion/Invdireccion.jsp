<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridInvdireccion" var="urlgridInvdireccion" />
        <c:url value="/exportInvdireccion" var="recordsExportUrlInvdireccion" />
        <c:url value="/saveInvdireccion" var="urlsaveInvdireccion" />
        <c:url value="/deleteInvdireccion" var="urldeleteInvdireccion" />
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
                        <h3>Invdireccion
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
                        </div>
                    </div>
                </div>
            </section>
            <!-- Page footer-->
            <%@include file="/WEB-INF/views/footer.jsp" %>
        </div>

        <!-- Modal-->
        <div id="modalInvdireccion" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formInvdireccion" action="${urlsaveInvdireccion}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDDIRECCION</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="iddireccion" name="iddireccion"  required="true"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DESCRIPCIONDIRECCION</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="1" maxlength="100"   id="descripciondireccion" name="descripciondireccion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">LUGARDIRECCION</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="2" maxlength="25"   id="lugardireccion" name="lugardireccion"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDCLIENTE</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvcliente"   id="invclienteDelegate"  name="invcliente.idcliente"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDPROVEEDOR</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvproveedor"   id="invproveedorDelegate"  name="invproveedor.idproveedor"  readonly="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">IDUSUARIO</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/Inventario/cbofilterInvusuario"   id="invusuarioDelegate"  name="invusuario.idusuario"  readonly="true" />
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
        

