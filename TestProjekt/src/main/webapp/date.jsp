
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World JSP</title>
</head>
<body>
	<%LocalDateTime now = LocalDateTime.now();

	int hour = now.getHour();
	int min = now.getMinute();
	int sec = now.getSecond();
	out.println(hour + ":" + min + ":" + sec);
	if (sec % 2 == 0) {
		out.println(" Die Sekundenanzahl ist gerade.");
		 }
		 else {
			out.println("Die Sekundenanzahl ist ungerade.");} %>
	
</body>
</html>