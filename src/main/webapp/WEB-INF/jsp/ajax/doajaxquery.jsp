<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/23
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax的查询</title>
    <link href="${pageContext.request.contextPath}/static/hplus/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/hplus/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/hplus/css/style.min.css" rel="stylesheet">
    <!-- 引入分页插件-->
    <link href="${pageContext.request.contextPath}/static/pagination-2.1.4/css/pagination.css" rel="stylesheet">

</head>

<script type="text/javascript">
    function doQuery() {
        console.log("iopifopsdipof")
        $.ajax({
            type: "post",
            url: "listquerybylike",
            data: $("#form1").serialize(),
            dataType: "json",
            success: function (data) {
                console.log(data);
                var value = "";
                if (data) {
                    // 将ajax查询的json数据，使用分页插件进行处理、
                    $("#myPaging").pagination({
                        dataSource: data, // 分页的数据源
                        pageSize: 8, // 每一页显示的记录条数
                        pageNumber: 1, // 开始定位在第1页
                        callback: function (eachPageData, pagination) {// 每次翻页的时候的回调函数
                            value = "";
                            $.each(data, function (index, eachValue) {
                                value += "<tr>";
                                value += "<th scope='row'>" + (index + 1) + "</th>";
                                value += "<td>" + eachValue.customerName + "</td>";
                                value += "<td>" + eachValue.customerPass + "</td>";
                                value += "<td>" + eachValue.customerSex + "</td>";
                                value += "<td>" + eachValue.customerAge + "</td>";
                                value += "<td>" + eachValue.date + "</td>";
                                value += "<td><img style=\"width: 30px;height: 30px\" src='" + eachValue.userimg + "'></img></td>";
                                value += "</tr>";
                            });
                            // 显示每一页的内容
                            // 将拼接内容显示到指定的控件中
                            // 局部刷新浏览器的dom对象
                            $("#displayInfo").html(value);
                        }
                    });

                }

            },
            error: function () {
                alert("服务器错误");
            }
        });
    }
</script>
<body>

<form class="form-horizontal" id="form1">

    <div class="form-group">
        <label class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="customerName" name="customerName" placeholder="请输入姓名">
        </div>

    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">年龄</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="customerAge" name="customerAge" placeholder="请输入年龄">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-default" onclick="doQuery()">查询</button>
        </div>
    </div>
</form>

<table class="table table-striped">
    <caption>用户的信息</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>注册日期</th>
        <th>头像</th>

    </tr>
    </thead>
    <tbody id="displayInfo">
    <%--此处有jquery通过ajax查询之后的回调函数进行局部刷新操作--%>
    </tbody>
</table>
<div class="row">
    <div class="col-sm-12" id="myPaging">
        <%--分页插件需要显示的内容，运行时动态添加--%>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/hplus/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/plugins/layer/layer.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/hplus.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hplus/js/contabs.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/plugins/pace/pace.min.js"></script>
<%--分页插件--%>
<script src="${pageContext.request.contextPath}/static/pagination-2.1.4/js/pagination.min.js"></script>
</body>
</html>
