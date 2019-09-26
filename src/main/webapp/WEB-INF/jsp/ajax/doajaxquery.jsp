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
    <%--引入分页插件--%>
    <link href="${pageContext.request.contextPath}/static/pagination-2.1.4/css/pagination.css" rel="stylesheet">
    <%--引入弹出模态框的插件--%>
    <link href="${pageContext.request.contextPath}/static/BootstrapEx/css/bootstrapEx.css" rel="stylesheet">

</head>

<script type="text/javascript">
    /*查询操作*/
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
                        pageSize: 5, // 每一页显示的记录条数
                        pageNumber: 1, // 开始定位在第1页
                        callback: function (eachPageData, pagination) {// 每次翻页的时候的回调函数
                            value = "";
                            $.each(eachPageData, function (index, eachValue) {
                                value += "<tr>";
                                value += "<th scope='row'>" + (index + 1) + "</th>";
                                value += "<td>" + eachValue.customerName + "</td>";
                                value += "<td>" + eachValue.customerPass + "</td>";
                                value += "<td>" + eachValue.customerSex + "</td>";
                                value += "<td>" + eachValue.customerAge + "</td>";
                                value += "<td>" + eachValue.date + "</td>";
                                value += "<td><img style=\"width: 30px;height: 30px\" src='" + eachValue.imgPath + "'></img></td>";
                                value += "<td><button type=\"button\" class=\"btn btn-primary\" onclick='showUpdateModify(" + JSON.stringify(eachValue) + ")'>修改</button>&nbsp;&nbsp;" +
                                    "<button type=\"button\" class=\"btn btn-danger\" onclick='deleteData("+eachValue.customerId+")'>删除</button></td>";
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

    //显示修改的模态框
    function showUpdateModify(eachValue) {
        // 使用浏览器客户单缓存对象  sessionStorage   localStorage
        sessionStorage.setItem("eachRow", JSON.stringify(eachValue));
        //定义模态框显示的页面,在web-info下，需要跳转后台进行访问
        var targetUrl = "forward?page=customermanage/updateCustomer";
        //显示页面
        var Modal3 = InitModal3(targetUrl);
        Modal3.show();
    }

    //Modal嵌入页签页初始化处理
    function InitModal3(targetUrl) {
        $(document.body).append('<div id="modal3"></div>');
        var Modal3 = new Modal();
        Modal3.renderto = "#modal3";
        Modal3.InitShow = true;
        Modal3.btns = [{id: "btn1", text: "保存"}, {id: "closebtn"}]
        var tab1 = new Tab();
        Modal3.OnfirstInited = function (thismodal) {
            tab1.tabs = [{
                id: "tabs1", title: "用户信息修改", active: true, isiframe: true, url: targetUrl
            }];
            tab1.renderto = thismodal.body;
            tab1.Init();
            // 给保存按钮添加一个点击事件
            $("#btn1").click(function () {
                // 使用jquery的选择器获取需要提交的form表单对象
                //console.log("modifyformmodifyformmodifyformmodifyformmodifyformmodifyform:::::");
               console.log($("#modal3 iframe").contents().find("#modifyform"));
                // 可以直接提交表单进行保存处理，
                // 也可以使用ajax进行处理，需要注意：实现ajax下的文件上传
                // 课下作业：使用ajax方式保存修改的数据，实现ajax下的文件上传
                // form表单提交保存数据，不推荐；推荐使用ajax方式进行保存
                $("#modal3 iframe").contents().find("#modifyform").submit();
            });
            /*给关闭按钮添加一个事件，点击关闭按钮后执行查询操作*/
            $("#closebtn").click(function () {
                //执行查询操作
                doQuery();
            });
        }
        return Modal3;
    }
    // 定义modal关闭之后的事件处理函数
    // 事件函数的命名时固定的：modal的id值_事件名


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    function deleteData(customerId) {
        // 使用ajax删除数据
        var r = confirm("是否确定删除该记录？")
        if (r == true) {
            $.post("deleteCustomerbyAjax", {"customerId": customerId}, function (data) {
                // 可以选择弹出框进行提示，也可以不作处理
                if (data && data == "1") {
                    // 重新查询，更新数据
                    doQuery();
                    // 课下作业：注意页码如何记录
                } else {
                    alert("删除失败");
                }
            });
        }
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
        <th>操作</th>
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
<%--模态框--%>
<script src="${pageContext.request.contextPath}/static/BootstrapEx/js/bootstrapEx.js"></script>
</body>
</html>
