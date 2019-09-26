<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/21
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jquery的测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.js"></script>
    <script type="text/javascript">
        /*function register() {
            //获得标签
            var $phone = $("#phone").val();
            $.ajax({
                url:"register2",
                请求方式:"post",
                data:"phone="+$phone,
                //如果正确信息，就执行该方法
                success: function (result, testStatus) {
                    if (result == "true") {
                        alert("手机号已经存在，请更换手机号");
                    } else {
                        alert("注册成功");
                    }
                },
                //错误信息执行该方法，服务端发生错误，就会执行
                error: function (xhr, errorMessage, e) {
                    alert("服务器发生错误");
                }
            });
        }*/

        /*通过post方法提交*/
        /*function register(){
            var $phone = $("#phone").val();
            $.post({
                url:"register3",
                data:"phone="+$phone,
                success:function (result, testStatus) {
                    if (result=="true"){
                        alert("手机号已经存在，请更换手机号");
                    } else{
                        alert("注册成功");
                    }
                }
            });
        }
        */

        /*通过ajax的get方法提交*/
       /* function register(){
            var $phone = $("#phone").val();
            $.get({
                url:"register4",
                data:"phone="+$phone,
                success:function (result, testStatus) {
                    if (result=="true"){

                        //alert("手机号已经存在，请更换手机号");
                    } else{
                        alert("注册成功");
                    }
                }
                });
        }*/
        /* function register(){

                        $("#tip").load(
                            "register5",
                            "phone="+$phone,
                            function(responseTxt,statusTxt,xhr){
                            if(statusTxt=="success")
                                alert("外部内容加载成功!");
                            if(statusTxt=="error")
                                alert("Error: "+xhr.status+": "+xhr.statusText);
                        });

                }*/
       /*ajax的load方法*/



       /*ajax的getJSON方法*/

       /* function register(){
             var $phone = $("#phone").val();
             $.getJSON({
                 url:"register6",
                 data:{"phone":$phone},
                 success:function (result, testStatus) {
                     if (result.message=="true"){
                         alert("手机号已经存在，请更换手机号");
                     } else{
                         alert("注册成功");
                     }
                 }
                 });
         }*/

         /*对json进行处理*/
        /*function register(){
            var $phone = $("#phone").val();
            $.getJSON({
                url:"register7",
                data:{"phone":$phone},
                success:function (result, testStatus) {
                    if (result.message=="true"){
                        alert("手机号已经存在，请更换手机号");
                    } else{
                        alert("注册成功");
                    }
                }
            });
        }
*/
    </script>
</head>
<body>

<input type="text" name="phone" id="phone"><br>
<input type="button" value="注册" onclick="register()">
<div id="tip"></div>


</body>
</html>
