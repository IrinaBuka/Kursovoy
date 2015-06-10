<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>User</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script language="javascript" src="/js/jquery.js" type="text/javascript"></script>
    <script language="javascript" src="/js/user.js" type="text/javascript"></script>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <main class="cd-main-content">
    <jsp:include page="includes/header.jsp"/>
<c:if test="${CURRENT_USER_ID!= null}">

<div class="fix bg-3">
    <jsp:include page="includes/header.jsp"/>
    <div class="container us">
</c:if>
<form id="edit-user-form">
    <fieldset>
        <legend>Edit User ${user.firstName} ${user.lastName}</legend>

        <div class="alert alert-success" style="display: none;">
            <strong>Saved!</strong> User saved successfully!
        </div>

        <div class="alert alert-error" style="display: none;">
            <strong>Error!</strong> User hasn't saved!
        </div>

    <div class="edit">
        <label>Login</label>
        <input id="login" type="text" value="${user.login}">
        <input id="userId" type="hidden" value="${user.userId}">
        <label>First Name</label>
        <input id="name" type="text" value="${user.firstName}">
        <label>Last Name</label>
        <input id="lastName" type="text" value="${user.lastName}">
        <label>Age</label>
        <input id="age" type="number" value="${user.age}">
        <label>Password</label>
        <input id="password" type="password" value="${user.password}">
     </div>   
                <button  class="btn kn" type="submit">Submit</button>
                <button class="btn kn"><a href="/deleteNote?noteId=${note.noteId}">Delete</a></button>
 
    </fieldset>
</form>
</div>
</div>
</main>
</body>
</html>