<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->


    <title>admin管理用户页面</title>

    <!-- Bootstrap -->

    <link
            href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css"
            rel="stylesheet">
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/static/html5shiv/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/respond/Respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/bootstrapSelect/css/bootstrap-select.min.css">
</head>
<body>
<div id="content_table" class="row">
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <tr>
                <td style="width: 30px;">
                    <input type="checkbox"
                           class="chkall" onclick="chkall();"></td>
                <td>用户名</td>
                <td>密码</td>
                <td>性别</td>
                <td>年龄</td>
                <td>资源路径</td>
                <td style="width: 100px;">操作</td>
            </tr>
            <c:forEach items="${customersbyPage.list}" var="customer">
                <tr>
                    <td><input value="${customer.customerId}" type="checkbox" name="chkuser"
                               class="chkone" onclick="chkone();"></td>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerPass}</td>
                    <td>${customer.customerSex}</td>
                    <td>${customer.customerAge}</td>
                    <td>${customer.imgPath}</td>
                    <td><a
                            href="${pageContext.request.contextPath}/admin/updateUser?id=${customer.customerId}"
                            data-target="#updateUserModal" data-toggle="modal">编辑</a> <a
                            href="${pageContext.request.contextPath}/admin/deleteUser?id=${customer.customerId}"
                            onclick="return delSure()">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div id="pager" class="row">
    <p class="pull-left">
        总共有<span> ${customersbyPage.total}</span>条记录，当前第<span> ${customersbyPage.pageNum}
    </span>页,共<span> ${customersbyPage.pages} </span>页
    </p>
    <div class="btngroup pull-right">
        <a href="${pageContext.request.contextPath}/doselectCustomer?pageNum=1&pageSize=6"
                type="button" class="btn btn-default">首页</a> <a
            href="${pageContext.request.contextPath}/doselectCustomer?pageNum=${customersbyPage.prePage}&pageSize=6"
            type="button" class="btn btn-default">上一页</a> <a
            href="${pageContext.request.contextPath}/doselectCustomer?pageNum=${customersbyPage.nextPage}&pageSize=6"
            type="button" class="btn btn-default">下一页</a> <a
            href="${pageContext.request.contextPath}/doselectCustomer?pageNum=${customersbyPage.pages}&pageSize=6"
            type="button" class="btn btn-default">尾页</a>
    </div>
</div>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
        src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
<!--  加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
        src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>