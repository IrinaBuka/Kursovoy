<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Note</title>
   <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script language="javascript" src="/js/jquery.js" type="text/javascript"></script>
    <script language="javascript" src="/js/note.js" type="text/javascript"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="includes/header.jsp"/>
<c:if test="${CURRENT_NOTE_ID!= null}">
<main class="cd-main-content">
    <jsp:include page="includes/header.jsp"/>
    
    </c:if>
    <div class="fix bg-3">
    <div class="container us">
    <form id="edit-note-form">
    <fieldset>
        <legend>Edit Note ${note.noteName} </legend>

        <div class="alert alert-success" style="display: none;">
            <strong>Saved!</strong> Note saved successfully!
        </div>

        <div class="alert alert-error" style="display: none;">
            <strong>Error!</strong> Note hasn't saved!
        </div>

<div class="edit">
        <label>Note name</label>
        <input id="noteName" type="text" value="${note.noteName}">
        <input id="noteId" type="hidden" value="${note.noteId}">
        <label>Note</label>
        <input id="noteBody" type="text" value="${note.noteBody}">
        <label>Data</label>
        <input id="date" type="text" value="${note.date}">
    </div>
        <button  class="btn kn" type="submit">Submit</button>
        <button class="btn kn"><a href="/deleteNote?noteId=${note.noteId}">Delete</a></button>
        
    </fieldset>
</form>
</div>

</main>
</body>
</html>