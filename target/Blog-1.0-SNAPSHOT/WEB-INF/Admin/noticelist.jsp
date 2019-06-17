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
    <title>发布公告</title>
    <!-- layui.css -->
    <link href="../plug/layui/css/layui.css" rel="stylesheet" />
</head>
<body>
<fieldset id="dataConsole" class="layui-elem-field layui-field-title"  style="display:block;">
    <legend>控制台</legend>
    <div class="layui-field-box">
        <div id="articleIndexTop">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item" style="margin:0;margin-top:15px;">
                    <div class="layui-inline">
                        <label class="layui-form-label">名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="keywords" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-input-inline" style="width:auto">
                            <button class="layui-btn" lay-submit lay-filter="formSearch">搜索</button>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline" style="width:auto">
                            <a id="addNotice" class="layui-btn layui-btn-normal">发布公告</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</fieldset>
<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field" style="display:block;">
    <legend style="text-align:center;">公告列表</legend>
    <div class="layui-field-box">
        <div class="">
            <table style="" class="layui-table" lay-even="">
            <colgroup>
                <col width="100">
                <col width="200">
                <col>
                <col width="200">
                <col width="200">
                <col width="90">
                <col width="50">
                <col width="50">
            </colgroup>
            <thead>
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>内容</th>
                <th>发布时间</th>
                <th>更新时间</th>
                <th>选项</th>
                <th colspan="2">操作</th>
            </tr>
            </thead>
            <tbody>

            <div id="insert" >
            <c:forEach items="${NoticeList}" var="notice">
                <tr class="myclass" id="${notice.noticeId}">

                    <td>${notice.noticeId}</td>
                    <td>${notice.noticeTitle}</td>
                    <td>${notice.noticeContent}</td>
                    <td><fmt:formatDate value="${notice.noticeCreateTime}" pattern="yyyy年MM月dd日"/></td>
                    <td><fmt:formatDate value="${notice.noticeUpdateTime}" pattern="yyyy年MM月dd日"/></td>
                    <td>
                        <form class="layui-form" action="">
                            <div class="layui-form-item" style="margin:0;">
                                <c:choose>
                                    <c:when test="${notice.noticeStatus==0}">
                                        <input type="checkbox" name="top" title="发布" lay-filter="publish" value="${notice.noticeId}">
                                        <div class="layui-unselect layui-form-checkbox layui-form-checked">
                                            <span>发布</span>
                                            <i class="layui-icon layui-icon-ok"></i>
                                        </div>
                                    </c:when>

                                    <c:when test="${notice.noticeStatus==1}">
                                        <input type="checkbox" name="top" title="发布" lay-filter="publish" value="${notice.noticeId}" checked="">
                                        <div class="layui-unselect layui-form-checkbox">
                                            <span>发布</span>
                                            <i class="layui-icon layui-icon-ok"></i>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </div>
                        </form>
                    </td>
                    <td>
                        <button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.datalist.editData(this,${notice.noticeId})">
                            <i class="layui-icon">&#xe642;</i></button>
                    </td>
                    <td>
                        <button class="layui-btn layui-btn-small layui-btn-danger" onclick="layui.datalist.deleteData(${notice.noticeId})">
                            <i class="layui-icon">&#xe640;</i></button>
                    </td>
                </tr>
            </c:forEach>
            </div>
            </tbody>
        </table>
        </div>
    </div>
</fieldset>
<div id="pageNav"  align="center"></div>
<script src="../js/jquery-3.4.1.min.js"></script>
<!-- layui.js -->
<script src="../plug/layui/layui.js"></script>
<script type="text/javascript">
    layui.config({
        base: '../js/'
    }).use('noticelist');
</script>
</body>
</html>
