<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
<form class="form" action="login" method="post">
  <span class="input-span">
    <label for="email" class="label">Email</label>
    <input type="email" name="email" id="email"
  /></span>
  <span class="input-span">
    <label for="password" class="label">Password</label>
    <input type="password" name="password" id="password"
  /></span>
  <span class="span"><a href="#">Forgot password?</a></span>
  <input class="submit" type="submit" value="Log in" />
  <span class="span">Don't have an account? <a href="/register.jsp">Sign up</a></span>
</form>
</body>
</html>