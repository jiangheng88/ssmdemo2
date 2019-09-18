<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户信息新增</title>
    <style rel="stylesheet">
        #maindiv{
            margin-top: 10px;
            width: 90%;
        }
    </style>
    <!--引入bootstrap的css文件-->
    <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--引入jquery，注意：jquery要在js文件之前引入，因为bootstrap使用了jquery框架-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jQuery/jquery.js"></script>
    <!--引入bootstrap的js文件-->
    <!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>-->
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div id="maindiv">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/doAddCustomer" method="post">

        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="customerName" name="customerName" placeholder="请输入姓名">
            </div>

            <label class="col-sm-2 control-label">密码</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="customerPass" name="customerPass" placeholder="请输入密码">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="customerAge" name="customerAge" placeholder="请输入年龄">
            </div>

            <label class="col-sm-2 control-label">性别</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="customerSex" name="customerSex" placeholder="请输入性别">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">注册日期</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" id="userregdate" name="date" placeholder="请选择日期">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">保存</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
