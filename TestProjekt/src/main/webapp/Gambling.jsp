<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Scanner" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gambling" method="post">
    <label for="zahl1">Erste Zahl:</label>
    <input type="text" id="zahl1" name="zahl1"><br><br>

    <label for="zahl2">Zweite Zahl:</label>
    <input type="text" id="zahl2" name="zahl2"><br><br>

    <label for="zahl3">Dritte Zahl:</label>
    <input type="text" id="zahl3" name="zahl3"><br><br>

    <label for="zahl4">Vierte Zahl:</label>
    <input type="text" id="zahl4" name="zahl4"><br><br>

    <label for="zahl5">Fünfte Zahl:</label>
    <input type="text" id="zahl5" name="zahl5"><br><br>

    <label for="zahl6">Sechste Zahl:</label>
    <input type="text" id="zahl6" name="zahl6"><br><br>

    <button type="submit">submit</button>
				       </form>	
		<h2>Deine Zahlen</h2>
<p>${zahl1}, ${zahl2}, ${zahl3}, ${zahl4}, ${zahl5}, ${zahl6}</p>

<h2>Gezogene Zahlen</h2>
<p>${randomNumber}, ${randomNumber2}, ${randomNumber3}, ${randomNumber4}, ${randomNumber5}, ${randomNumber6}</p>

<h2>Ergebnis</h2>
<p>Preis: ${prize}</p>				       
</body>
</html>