<%-- 
    Document   : REPORTEGENERAL
    Created on : 26/09/2013, 03:33:58 PM
    Author     : Unknown
--%>

<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.sql.*" %> 
<% /*Parametros para realizar la conexi�n*/ 
Connection conexion; 
Class.forName("org.postgresql.Driver").newInstance(); 
conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tutorial","postgres","admin2012");
/*Establecemos la ruta del reporte*/ 
File reportFile = new File(application.getRealPath("REPORTES/RGENERAL.jasper")); 
/* No enviamos par�metros porque nuestro reporte no los necesita asi que escriba 
cualquier cadena de texto ya que solo seguiremos el formato del m�todo runReportToPdf*/ 
Map parameters = new HashMap(); parameters.put("Nombre_parametro", "Valor_Parametro"); 
/*Enviamos la ruta del reporte, los par�metros y la conexi�n(objeto Connection)*/ 
byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (), parameters, conexion); 
/*Indicamos que la respuesta va a ser en formato PDF*/ response.setContentType("application/pdf");
response.setContentLength(bytes.length); ServletOutputStream ouputStream = response.getOutputStream(); 
ouputStream.write(bytes, 0, bytes.length); /*Limpiamos y cerramos flujos de salida*/ ouputStream.flush(); 
ouputStream.close(); %>
