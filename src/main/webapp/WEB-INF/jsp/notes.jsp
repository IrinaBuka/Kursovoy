<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Managment System</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<main class="cd-main-content">
<jsp:include page="includes/header.jsp"/>
    <div class="fix bg-2">
        <div class="container us">
        <table class="table">
            <thead>
            <tr>
                <th>Note name</th>
                <th>date</th>
                <th>Note</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach var="note" items="${notes}">
                <tr>
                    <td>${note.noteName} </td>
                    <td> ${note.date} </td>
                    <td>${note.noteBody} </td>
                    <td><a href="/note?noteId=${note.noteId}"><i class="icon-edit"></i></a>
                        <a href="/deleteNote?noteId=${note.noteId}"><i class="icon-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </div>
</main>
</body>
</html>