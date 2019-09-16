<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" name="username">
    <input type="password" name="userpass">
    <input type="submit" value="提交">
</form>
</body>
</html>
