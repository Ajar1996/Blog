<%--
  Created by IntelliJ IDEA.
  User: zhoujiahai
  Date: 2019/5/29
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8" />
    <title>用户列表</title>
    <!-- layui.css -->
    <link href="../plug/layui/css/layui.css" rel="stylesheet" />
    <style>
        .layui-btn-small {
            padding: 0 15px;
        }

        .layui-form-checkbox {
            margin: 0;
        }
        tr td:not(:nth-child(0)),
        tr th:not(:nth-child(0)) {
            text-align: center;
        }

        #dataConsole {
            text-align: center;
        }
        /*分页页容量样式*/
        /*可选*/
        .layui-laypage {
            display: block;
        }

        /*可选*//*
        .layui-laypage > * {
            float: left;
        }*/
        /*可选*/
        .layui-laypage .laypage-extend-pagesize {
            float: right;
        }
        /*可选*/
        .layui-laypage:after {
            content: ".";
            display: block;
            height: 0;
            clear: both;
            visibility: hidden;
        }

        /*必须*/
        .layui-laypage .laypage-extend-pagesize {
            height: 30px;
            line-height: 30px;
            margin: 0px;
            border: none;
            font-weight: 400;
        }
        /*分页页容量样式END*/
    </style>
</head>
<body>
<fieldset id="dataConsole" class="layui-elem-field layui-field-title"  style="display:block;">
    <legend>控制台</legend>
    <div class="layui-field-box">
        <div id="articleIndexTop">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item" style="margin:0;margin-top:15px;">
                    <div class="layui-inline">
                        <label class="layui-form-label">分类</label>
                        <div class="layui-input-inline">
                            <select name="city">
                                <option value=""></option>
                                <option value="0">普通用户</option>
                                <option value="1">管理员</option>
                            </select>
                        </div>
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="keywords" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-input-inline" style="width:auto">
                            <button class="layui-btn" lay-submit lay-filter="formSearch">搜索</button>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline" style="width:auto">
                            <a id="addArticle" class="layui-btn layui-btn-normal">发表文章</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</fieldset>
<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field" style="display:block;">
    <legend style="text-align:center;">文章列表</legend>
    <div class="layui-field-box">
        <div id="insert" class="">
<%--插入的内容--%>

        </div>
    </div>
</fieldset>
<input type="hidden" value="10" id="total"/>
<div id="pageNav"  align="center"></div>
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/userlist.js"></script>
<!-- layui.js -->
<script src="../plug/layui/layui.js"></script>
<script type="text/javascript">
    layui.config({
        base: '../js/'
    }).use('userlist');
</script>

</body>
</html>
