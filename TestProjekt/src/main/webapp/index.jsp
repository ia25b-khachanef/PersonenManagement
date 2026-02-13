
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World JSP</title>
</head>
<body>

	<% List<String> list = new ArrayList<>();
	list.add("marc");
	%>
	
	<%out.println(list);%>
	
</body>
</html>