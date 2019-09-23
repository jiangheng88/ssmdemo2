<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/21
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<script type="text/javascript">
    function register() {
        //获得标签
        var phone = document.getElementById("phone").value;
        //通过ajax请求服务端,前面没有var 袖修饰，表名他是全局变量
        xmlHttpRequest = new XMLHttpRequest();
        //设置xmlHttpRequest的回调函数,这里是方法的引用，没有括号
        xmlHttpRequest.onreadystatechange = callBack;
        xmlHttpRequest.open("post", "register", true);
        //设置post的响应头application/x-www-form-urlencoded
        xmlHttpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttpRequest.send("phone=" + phone);
    }

    //定义回调函数，接受服务端返回的结果
    function callBack() {
        if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
//接受服务端返回的结果
            var data = xmlHttpRequest.responseText;//结果是字符串的形式
            if (data =="true"){
                alert("号码已经存在，请更换号码");
            }else{
                alert("注册成功");
            }
        } else {
        }
    }
</script>
<head>
    <title>利用原生的js实现ajax</title>
</head>
<body>

<input type="text" name="phone" id="phone"><br>
<input type="button" value="注册" onclick="register()">
</body>
</html>
