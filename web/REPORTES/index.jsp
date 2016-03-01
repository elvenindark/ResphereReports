<%-- 
    Document   : index
    Created on : 26/09/2013, 03:32:39 PM
    Author     : Unknown
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <f:view>
            <h:outputLabel>REPORTES PDF CON PARAMETROS EN JSP Y POSTGRESQL</h:outputLabel><br><br>
            <h:form>
                <h:panelGrid columns="4">
                    <h:outputLabel value="Provincia:"></h:outputLabel>
                    <h:outputLabel value="Canton:"></h:outputLabel>
                    <h:outputLabel value="Fecha:"></h:outputLabel>
                    <h:outputLabel value="Evento:"></h:outputLabel>
                
                </h:panelGrid>
                
            </h:form>
            <a href="faces/REPORTEGENERAL.jsp">REPORTE GENERAL</a><br>
            <a href="faces/formulario.jsp">REPORTE POR CODIGO DE CLIENTE</a>
        </f:view>
    </body>
</html>
