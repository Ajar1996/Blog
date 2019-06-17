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

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>编辑文章页面</title>
    <!-- layui.css -->
    <link href="../plug/layui/css/layui.css" rel="stylesheet" />
    <link href="../plug/wangEditor-master/release/wangEditor-fullscreen-plugin.css" rel="stylesheet" />

</head>
<body>
<hr>
<div class="layui-row layui-col-space15" style="margin:0;">
    <div id="article-post" class="layui-col-md12">
        <div class="layui-tab layui-tab-card">
            <div class="layui-tab-content start">

                <fieldset class="layui-elem-field layui-field-title">
                    <legend>发布文章</legend>
                </fieldset>
                <div class="layui-form" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">标题</label>
                        <div class="layui-input-block">
                            <input type="text" name="articleTitle" required lay-verify="required" placeholder="请输入标题"
                                   autocomplete="off" class="layui-input" value="${article.articleTitle}">
                        </div>
                    </div>

                    <div class="layui-form-item layui-col-md6">
                        <label class="layui-form-label">文章分类</label>
                        <div class="layui-input-block">
                            <select name="articleCategory" lay-verify="required">
                                <option value=""></option>
                                <c:forEach items="${categoryList}" var="category">
                                    <option value="${category.categoryName}">${category.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">内容</label>
                        <div class="layui-input-block" style="max-width: 1080px;">
                            <div id="editor">
                                <div>
                                ${article.articleContent}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">文章摘要</label>
                        <div class="layui-input-block">
                            <textarea name="articleSummary" placeholder="如果不填，则取文章内容的开头小部分（不包含图片以及文字格式）" class="layui-textarea"
                                      style="resize: none;">${article.articleSummary}</textarea>
                        </div>
                    </div>
                    <input  name="articleId" type="hidden" value="${article.articleId}">

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即发布</button>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../plug/wangEditor-master/release/wangEditor.min.js"></script>

<script src="../plug/wangEditor-master/release/wangEditor-fullscreen-plugin.js"></script>

<!-- layui.js -->
<script src="../js/jquery-3.4.1.min.js"></script>
    <script src="../plug/layui/layui.js"></script>
    <!-- layui规范化用法 -->
    <script type="text/javascript">
        layui.config({
            base: '../js/'
        }).use('editor');
    </script>
</body>
</html>