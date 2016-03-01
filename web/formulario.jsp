<%-- 
    Document   : formulario
    Created on : 26/09/2013, 03:46:47 PM
    Author     : Unknown
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" method="post" action="REPORTECODIGO.jsp">
      <table width="487" align="center">
        <tr>
          <td colspan="2" align="center"><strong>REPORTES PDF CON PARAMETROS EN JSP </strong></td>
        </tr>
        <tr>
          <td width="168">INGRESE CODIGO:</td>
          <td width="415"><label for="txtidcliente"></label>
          <input type="text" name="txtidcliente" id="txtidcliente"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><input type="submit" name="button" id="button" value="Generar Reporte"></td>
        </tr>
      </table>
    </form>
    </body>
</html>
