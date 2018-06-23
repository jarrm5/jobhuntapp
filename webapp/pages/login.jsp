<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../css/master.css">
	<title>jobhuntapp - Login</title>
</head>
<body>
	<h2>Alright everyone, it's time to Login</h2>
	<s:form action="login">
		<s:textfield key="username" label="Username" />
		<s:password showPassword="false" key="password" label="Password" />
		<s:submit /> 
	</s:form>

</body>
</html>
