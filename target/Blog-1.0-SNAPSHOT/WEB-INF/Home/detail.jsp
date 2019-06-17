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

<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>Ajar博客 - 文章专栏</title>
    <link rel="shortcut icon" href="../images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="../plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="../plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="../css/global.css" rel="stylesheet" />

    <!-- 本页样式表 -->
    <link href="../css/detail.css" rel="stylesheet" />

    <style>

        table {
            border-top: 1px solid #ccc;
            border-left: 1px solid #ccc;
        }
        table td,
        table th {
            border-bottom: 1px solid #ccc;
            border-right: 1px solid #ccc;
            padding: 3px 5px;
        }
        table th {
            border-bottom: 2px solid #ccc;
            text-align: center;
        }

        /* blockquote 样式 */
        blockquote {
            display: block;
            border-left: 8px solid #d0e5f2;
            padding: 5px 10px;
            margin: 10px 0;
            line-height: 1.4;
            font-size: 100%;
            background-color: #f1f1f1;
        }

        /* code 样式 */
        code {
            display: inline-block;
            *display: inline;
            *zoom: 1;
            background-color: #f1f1f1;
            border-radius: 3px;
            padding: 3px 5px;
            margin: 0 3px;
        }
        pre code {
            display: block;
        }

        /* ul ol 样式 */
        ul, ol {
            margin: 10px 0 10px 20px;
        }
    </style>



</head>
<body>

<!-- 导航 -->
<nav class="blog-nav layui-header">
    <div class="blog-container">
        <!-- QQ互联登陆 -->
        <c:choose>
            <c:when test="${user==null }">
                <a href="../login"  class="blog-user" style="color: #d0e5f2">
                    <h2>登录</h2>
                </a>
            </c:when>

            <c:when test="${user!=null }">
                <a class="blog-user" style="color: #d0e5f2">${sessionScope.user.userNickname}</a>
            </c:when>
        </c:choose>
        <input type="hidden" id="username" value="${user.userId}"/>
        <a class="blog-logo" href="home.jsp">BLOG</a>
        <!-- 导航菜单 -->
        <ul class="layui-nav" lay-filter="nav">
            <li class="layui-nav-item">
                <a href="../index"><i class="fa fa-home fa-fw"></i>&nbsp;网站首页</a>
            </li>
            <li class="layui-nav-item">
                <a href="../articleCategory"><i class="fa fa-file-text fa-fw"></i>&nbsp;文章专栏</a>
            </li>
            <li class="layui-nav-item">
                <a href="../resource"><i class="fa fa-tags fa-fw"></i>&nbsp;资源分享</a>
            </li>
            <li class="layui-nav-item">
                <a href="../timeline"><i class="fa fa-hourglass-half fa-fw"></i>&nbsp;点点滴滴</a>
            </li>
            <li class="layui-nav-item">
                <a href="../about"><i class="fa fa-info fa-fw"></i>&nbsp;关于本站</a>
            </li>
        </ul>
        <!-- 手机和平板的导航开关 -->
        <a class="blog-navicon" href="javascript:;">
            <i class="fa fa-navicon"></i>
        </a>
    </div>
</nav>
<!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <div class="blog-container">
            <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="../index" title="网站首页">网站首页</a>
                <a href="../articleCategory" title="文章专栏">文章专栏</a>
                <a><cite>${article.articleTitle}</cite></a>
            </blockquote>
            <div class="blog-main">
                <div class="blog-main-left">
                    <!-- 文章内容（使用Kingeditor富文本编辑器发表的） -->
                    <div class="article-detail shadow">
                        <div class="article-detail-title">
                            ${article.articleTitle}
                        </div>
                        <div class="article-detail-info">
                            <span>发表时间：&nbsp;<fmt:formatDate value="${article.articleCreateTime}" pattern="yyyy年MM月dd日"/></span>
                            <span>作者：Ajar</span>
                            <span>浏览量：${article.articleViewCount}</span>
                        </div>
                        <div class="article-detail-content">
                            ${article.articleContent}
                        </div>
                        <input type="hidden" value=${article.articleId} id="articleId"/>
                    </div>
                    <!-- 评论区域 -->
                    <div class="blog-module shadow" style="box-shadow: 0 1px 8px #a6a6a6;">
                        <fieldset class="layui-elem-field layui-field-title" style="margin-bottom:0">
                            <legend>来说两句吧</legend>
                            <div class="layui-field-box">
                                <form class="layui-form blog-editor" action="">
                                    <div class="layui-form-item">
                                        <textarea name="editorContent" lay-verify="content" id="remarkEditor" placeholder="请输入内容" class="layui-textarea layui-hide"></textarea>
                                    </div>
                                    <div class="layui-form-item">
                                        <button class="layui-btn" lay-submit="formRemark" lay-filter="formRemark">提交评论</button>
                                    </div>
                                </form>
                            </div>
                        </fieldset>
                        <div class="blog-module-title">最新评论</div>

                        <ul class="blog-comment">
                            <c:forEach items="${commonList}" var="common">
                            <li>
                                <div class="comment-parent">
                                    <img src="../images/Absolutely.jpg" alt="absolutely" />
                                    <div class="info">
                                        <span class="username">${common.commentAuthorName}</span>
                                        <span class="time"><fmt:formatDate value="${common.commentCreateTime}" pattern="yyyy年MM月dd日"/></span>
                                    </div>
                                    <div class="content">
                                       ${common.commentContent}
                                    </div>
                                </div>
                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="blog-main-right">
                    <!--右边悬浮 平板或手机设备显示-->
                    <div class="category-toggle"><i class="fa fa-chevron-left"></i></div><!--这个div位置不能改，否则需要添加一个div来代替它或者修改样式表-->
                    <div class="article-category shadow">
                        <div class="article-category-title">分类导航</div>
                        <!-- 点击分类后的页面和artile.html页面一样，只是数据是某一类别的 -->
                        <c:forEach items="${categoryList}" var="category">
                            <a href="javascript:layer.msg(&#39;切换到相应分类&#39;)">${category.categoryName}</a>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">相似文章</div>
                        <ul class="fa-ul blog-module-ul">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="#">未开发</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="#">未开发</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="#">未开发</a></li>
                        </ul>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">随便看看</div>
                        <ul class="fa-ul blog-module-ul">
                            <c:forEach items="${hotArticle}" var="article" end="7">
                                <li><i class="fa-li fa fa-hand-o-right"></i><a href="../article/${article.articleId}">${article.articleTitle}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <!-- 底部 -->
<footer class="blog-footer">
    <p><span>Copyright</span><span>&copy;</span><span>2019</span><a href="www.interesting1996.shop:8080/Blog">BLOG</a><span>Design By Ajar</span></p>
    <p><a href="http://www.miibeian.gov.cn/" target="_blank">粤ICP备19024030号</a></p>
</footer>
    <!--侧边导航-->
<ul class="layui-nav layui-nav-tree layui-nav-side blog-nav-left layui-hide" lay-filter="nav">
    <li class="layui-nav-item layui-this">
        <a href="../index"><i class="fa fa-home fa-fw"></i>&nbsp;网站首页</a>
    </li>
    <li class="layui-nav-item">
        <a href="../articleCategory"><i class="fa fa-file-text fa-fw"></i>&nbsp;文章专栏</a>
    </li>
    <li class="layui-nav-item">
        <a href="../resource"><i class="fa fa-tags fa-fw"></i>&nbsp;资源分享</a>
    </li>
    <li class="layui-nav-item">
        <a href="../timeline"><i class="fa fa-road fa-fw"></i>&nbsp;点点滴滴</a>
    </li>
    <li class="layui-nav-item">
        <a href="../about"><i class="fa fa-info fa-fw"></i>&nbsp;关于本站</a>
    </li>
</ul>
    <!--分享窗体-->
    <div class="blog-share layui-hide">
        <div class="blog-share-body">
            <div style="width: 200px;height:100%;">
                <div class="bdsharebuttonbox">
                    <a class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                    <a class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                    <a class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
                    <a class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
                </div>
            </div>
        </div>
    </div>
    <!--遮罩-->
    <div class="blog-mask animated layui-hide"></div>
    <!-- layui.js -->
    <script src="../plug/layui/layui.js"></script>
    <!-- 自定义全局脚本 -->
    <script src="../js/global.js"></script>
    <!-- 比较好用的代码着色插件 -->
    <script src="../js/prettify.js"></script>
    <!-- 本页脚本 -->
    <script src="../js/detail.js"></script>
</body>
</html>