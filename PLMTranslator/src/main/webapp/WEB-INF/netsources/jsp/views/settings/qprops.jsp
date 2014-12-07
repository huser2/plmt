<%@page import="java.util.HashMap"%>
<%@page import="com.plm.conn.properties.QueueProperties"%>
<%@page import="java.util.Properties"%>
<%@page import="com.plm.conn.jms.ApplicationContextProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
sdfslfhsldfkshfslkh
<%
//Properties prop =(Properties) ApplicationContextProvider.getApplicationContext().getBean("ptqproperties");
//out.print(prop);
HashMap value =(HashMap) request.getAttribute("props");
out.print(value);
%>

</body>
</html>