<%-- 
    Document   : getimagename
    Created on : 2 Jun, 2016, 2:19:56 AM
    Author     : dell1
--%>

<%@ page import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"> 
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Parameter value = 
<%=request.getParameter("string1") %>
<% String value=request.getParameter("string1");
out.println(value);%>
</body>
</html>
