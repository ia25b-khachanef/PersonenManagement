<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CreatePerson</title>
</head>
<body>


       <form action="Person" method="post">
            
            <label for="zahl2">Vorname:</label>
    <input type="text" id="vorname" name="vorname"><br><br>
    
    <label for="zahl2">Nachname:</label>
    <input type="text" id="nachname" name="nachname"><br><br>    
    
  <input type="submit" value="Speichern"onclick="window.location.href='CreatePerson.jsp'">
  <input type="button" value="Hub"onclick="window.location.href='Hub.jsp'">
  <input type="button" value="DELETE"onclick="window.location.href='Person'">
    </form>
    
   
    
</body>
</html>