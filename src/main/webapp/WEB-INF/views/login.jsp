<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<html>
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>

        <title>Login Page</title>
        <style>
            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            }

            .msg {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }

            #login-box {
                width: 300px;
                padding: 20px;
                margin: 100px auto;
                background: #fff;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border: 1px solid #000;
            }
        </style>
    </head>
    <body>
        <div class="wrapper">
            <div class="abs-center wd-xl">
                <!-- START panel-->
                <div class="p">
                    <img src="" alt="Avatar" width="60" height="60" class="img-thumbnail img-circle center-block">
                </div>
                <div class="panel widget b0">
                    <div class="panel-body">
                        <p class="text-center">
                            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                <font color="red">
                                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                                </font>
                            </c:if>
                        </p>
                        <form   role="form" name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <div class="form-group has-feedback">
                                <input id="exampleInputUser" type="text" placeholder="Usuario" class="form-control" name="user">
                                <span class="fa fa-lock form-control-feedback text-muted"></span>
                            </div>

                            <div class="form-group has-feedback">
                                <input id="exampleInputPassword1" type="password" placeholder="Contraseña" class="form-control" name="pass">
                                <span class="fa fa-lock form-control-feedback text-muted"></span>
                            </div>
                             <div class="form-group has-feedback pull-right">
                                <input class="btn btn-sm btn-primary" name="submit" type="submit" value="Ingresar" />

                            </div>
                    </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</body>
</html>

