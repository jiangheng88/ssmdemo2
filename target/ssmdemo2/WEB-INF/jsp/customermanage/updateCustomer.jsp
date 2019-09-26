<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/static/hplus/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/hplus/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/hplus/css/style.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/hplus/js/jquery.min.js"></script>
    <script type="text/javascript">
        // 使用ajax查询需要修改数据的信息
        // 使用jquery的dom ready事件，在页面加载完成之后就将数据进行查询
        $(function () {
            // 从浏览器缓存中将修改的数据取出
            var eachRow = sessionStorage.getItem("eachRow")||null;
            // sessionStorage中缓存的是一个json的字符串形式，需要将字符串形式转换为json对象形式
            var eachBean = JSON.parse(eachRow);
            // 进行dom操作将需要修改的数据显示在修改页面的form表单中
            $("#customerid").val(eachBean.customerId);
            $("#customerName").val(eachBean.customerName);
            $("#customerPass").val(eachBean.customerPass);
            $("#customerAge").val(eachBean.customerAge);
            $("#customerSex").val(eachBean.customerSex);
            $("#customerregdate").val(eachBean.date);
            //$("#multipartFile").val(eachBean.imgPath);
            // 修改数据显示完成之后，将sessionStorage中的缓存数据清除
            sessionStorage.removeItem("eachRow");
        });

    </script>
</head>
<body>
<div id="maindiv">
    <form  id="modifyform" class="form-horizontal" action="${pageContext.request.contextPath}/updateCustomer"
          method="post" enctype="multipart/form-data">
        <!--使用隐藏表单，保存主键字段；用于区分是新增还是修改-->
        <input type="hidden" class="form-control" id="customerid" name="customerId">
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="customerName" name="customerName" placeholder="请输入姓名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">密码</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="customerPass" name="customerPass" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="customerAge" name="customerAge" placeholder="请输入年龄">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">性别</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="customerSex" name="customerSex" placeholder="请输入性别">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">注册日期</label>
            <div class="col-sm-4" id="txtCreateDate1">
                <input type="date" class="form-control" id="customerregdate" name="date" placeholder="请选择日期">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">上传头像</label>
            <div class="col-sm-4">
                <input type="file" class="form-control" id="multipartFile" name="file_imgPath" placeholder="">
            </div>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/static/hplus/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/plugins/layer/layer.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/hplus.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hplus/js/contabs.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hplus/js/plugins/pace/pace.min.js"></script>
</body>
</html>
