<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Begrüssung</title>
</head>
<body>

<%
    String name = (String) request.getAttribute("username");
    if (name != null) {
%>
        <h1>Hallo <%= name %>!</h1>
<%
    } else {
%>
        <h1>Hallo! Bitte gib deinen Namen ein:</h1>
        <form action="Controller" method="post">
            <input type="text" name="username">
            <input type="submit" value="Speichern">
        </form>
<%
    }
%>

</body>
</html>