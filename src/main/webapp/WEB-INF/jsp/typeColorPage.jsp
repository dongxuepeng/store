<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>颜色类型</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modules/layer/default/layer.css"  media="all">
    <style>
        .layui-icon{
            margin-top: 20px;
        }
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
            transform: translateY(-30%);
        }
    </style>
</head>
<body>
<form class="layui-form" action="javascript:;">
<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">主键：</label>
        <div class="layui-input-inline">
            <input class="layui-input" name="id" id="queryId" autocomplete="off">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">颜色名称：</label>
        <div class="layui-input-inline">
            <input class="layui-input" name="name" id="queryName" autocomplete="off">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">所属商品：</label>
        <div class="layui-input-inline">
            <select name="queryGoodsId" lay-verify="required" lay-search="" id="queryGoodsId">
            </select>
        </div>
    </div>
    <button class="layui-btn" data-type="reload" id="queryBtn">搜索</button>
    <button class="layui-btn" data-type="clear" id="clearBtn">重置</button>
</div>
</form>
<table class="layui-hide" id="test" lay-filter="test"></table>
<!--这里是弹出层的表单信息
//表单的id用于表单的选择，style是在本页隐藏，只有点击编辑才会弹出-->
<div class="layui-row" id="dataDiv" style="display:none;">
    <div class="layui-col-md10">
        <form class="layui-form layui-from-pane" action="" style="margin-top:20px" >
            <div class="layui-form-item">
                <label class="layui-form-label">主键：</label>
                <div class="layui-input-block">
                    <input type="text" id="typeId" name="typeId" readonly="readonly"
                           required  lay-verify="required" autocomplete="off" placeholder="" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">所属商品：</label>
                <div class="layui-input-block">
                    <select name="goodsTypeId" lay-verify="required" lay-search="" id="goodsTypeId">
                        <%--<option value="">直接选择或搜索选择</option>
                        <option value="1">layer</option>--%>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">颜色名称：</label>
                <div class="layui-input-block">
                    <input type="text" id="typeName" name="typeName"
                           required  lay-verify="required" autocomplete="off" placeholder="请输入颜色名称" class="layui-input">
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="addItem">新增</button>
        <button class="layui-btn layui-btn-sm" lay-event="delSelect">批量删除</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="${pageContext.request.contextPath}/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/jQuery-3.5.1.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/colorTypeList.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
</body>
</html>