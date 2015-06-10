<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Signin</title>
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script language="javascript" src="/js/jquery.js" type="text/javascript"></script>
    <script language="javascript" src="/js/login.js" type="text/javascript"></script>
</head>

<body>
    <main class="cd-main-content">
    <div class="fix bg-1"> 
        <div class="container">
            <div class="reg">
                <form id="doLogin" class="form-signin">
                            <h4><span id="error" class="label label-important"></span></h4>
                            <label for="inputLogin" class="sr-only">LOGIN</label>
                            <input type="text" id="inputLogin" class="form-control" placeholder="User Name" required autofocus>
                            <label for="inputPassword" class="sr-only">PASSWORD</label>
                            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                        
                        <div class="btn_my">
                            <button  class="btn" type="submit">Sign in</button>
                            <button class="btn"> <a href="/selfRegistration" >Sign Up</a></button>
                        </div>              
                </form>
            </div>
            </div>            
          </div>
    </main>
</body>
</html>

