<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>portal</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css"  media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modules/layer/default/layer.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<table style="width: 100%; height: 100%;">
    <tr height="15%" style="background-color: #1E9FFF">
        <td colspan="2">portal</td>
    </tr>
    <tr height="85%">
        <td width="10%" align="left" valign="top" style="background-color: #009E94">
            <ul class="layui-nav layui-nav-tree layui-bg-cyan layui-inline" lay-filter="navs" style="width: 100%;">
                <li class="layui-nav-item" id="lbwh">
                    <a href="javascript:;" data-id="lbwh">类别维护</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-id="lbwh_sp">商品类别</a></dd>
                        <dd><a href="javascript:;" data-id="lbwh_ys">颜色类别</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item" id="spgl">
                    <a href="javascript:;" data-id="spgl">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-id="spgl_1">商品1</a></dd>
                        <dd><a href="javascript:;" data-id="spgl_2">商品2</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item" id="syfx">
                    <a href="javascript:;" data-id="syfx">收益分析</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-id="syfx_sp">按商品</a></dd>
                        <dd><a href="javascript:;" data-id="syfx_sj">按时间</a></dd>
                    </dl>
                </li>
            </ul>
        </td>
        <td width="90%" valign="top">
            <div class="layui-tab" lay-filter="tabs" lay-allowclose="true">
                <ul class="layui-tab-title">

                </ul>
                <div class="layui-tab-content">

                </div>
            </div>
        </td>
    </tr>
</table>
<script src="${pageContext.request.contextPath}/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/jQuery-3.5.1.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/lay/modules/layer.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/portal.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
</body>

</html>
