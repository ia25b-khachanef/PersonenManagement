<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.UUID" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Person" method="post">
  <c:forEach var="p" items="${persons}">
    <div class="person-row" data-id="${p.uuid}">
    <form action="Person" method="post" style="display:inline;">
      <input type="hidden" name="id" value="${p.uuid}">

      <input type="text" name="vorname" value="${p.vorname}">
      <input type="text" name="nachname" value="${p.nachname}">

      <button type="submit">Speichern</button>
    </form>

    <button type="button" class="btn-delete" data-id="${p.uuid}">Delete</button>
</div>
    <br>
  </c:forEach>
</form>
<script>
document.addEventListener("click", async (e) => {

	if (!e.target.classList.contains("btn-delete")) return;

    const id = e.target.dataset.id;


    try {
        const res = await fetch("Person?uuid=" + encodeURIComponent(id), {
            method: "DELETE",
            headers: { "Accept": "application/json" }
        });

        if (!res.ok) throw new Error("HTTP " + res.status);

        const data = await res.json();

        if (!data.ok) throw new Error("Delete fehlgeschlagen");

       
        e.target.closest(".person-row").remove();

    } catch (err) {
        alert("Fehler beim Löschen: " + err.message);
    }
});
</script>

<input type="button" value="Hub"onclick="window.location.href='Hub.jsp'">
 <input type="button" value="CREATE"onclick="window.location.href='CreatePerson.jsp'">
</body>
</html>