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
    <meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>Ajar博客 - 点点滴滴 - 时光轴</title>
    <link rel="shortcut icon" href="images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!-- animate.css -->
    <link href="css/animate.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="css/timeline.css" rel="stylesheet" />
</head>
<body>
    <!-- 导航 -->
    <nav class="blog-nav layui-header">
        <div class="blog-container">
            <!-- QQ互联登陆 -->
            <c:choose>
                <c:when test="${user==null }">
                    <a href="login" class="blog-user" style="color: #d0e5f2">
                        <h2>登录</h2>
                    </a>
                </c:when>

                <c:when test="${user!=null }">
                    <a class="blog-user" style="color: #d0e5f2">${sessionScope.user.userNickname}</a>
                </c:when>
            </c:choose>

            <a class="blog-logo" href="home.jsp">BLOG</a>
            <!-- 导航菜单 -->
            <ul class="layui-nav" lay-filter="nav">
                <li class="layui-nav-item">
                    <a href="index"><i class="fa fa-home fa-fw"></i>&nbsp;网站首页</a>
                </li>
                <li class="layui-nav-item">
                    <a href="articleCategory"><i class="fa fa-file-text fa-fw"></i>&nbsp;文章专栏</a>
                </li>
                <li class="layui-nav-item">
                    <a href="resource"><i class="fa fa-tags fa-fw"></i>&nbsp;资源分享</a>
                </li>
                <li class="layui-nav-item layui-this">
                    <a href="timeline"><i class="fa fa-hourglass-half fa-fw"></i>&nbsp;点点滴滴</a>
                </li>
                <li class="layui-nav-item">
                    <a href="about"><i class="fa fa-info fa-fw"></i>&nbsp;关于本站</a>
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
                <a href="index" title="网站首页">网站首页</a>
                <a href="timeline" title="点点滴滴">点点滴滴</a>
                <a><cite>时光轴</cite></a>
            </blockquote>
            <div class="blog-main">
                <div class="child-nav shadow">
                    <span class="child-nav-btn child-nav-btn-this">时光轴</span>
                    <span class="child-nav-btn">笔记墙</span>
                </div>
                <div class="timeline-box shadow">
                    <div class="timeline-main">
                        <h1><i class="fa fa-clock-o"></i>时光轴<span> —— 记录生活点点滴滴</span></h1>
                        <div class="timeline-line"></div>
                        <div class="timeline-year">
                            <h2><a class="yearToggle" href="javascript:;">2019年</a><i class="fa fa-caret-down fa-fw"></i></h2>
                            <div class="timeline-month">
                                <h3 class=" animated fadeInLeft"><a class="monthToggle" href="javascript:;">6月</a><i class="fa fa-caret-down fa-fw"></i></h3>
                                <ul>
                                    <li class=" ">
                                        <div class="h4  animated fadeInLeft">
                                            <p class="date">06月13日</p>
                                        </div>
                                        <p class="dot-circle animated "><i class="fa fa-dot-circle-o"></i></p>
                                        <div class="content animated fadeInRight">配置到BLOG项目到服务器上</div>
                                        <div class="clear"></div>
                                    </li>
                                    <li class=" ">
                                        <div class="h4  animated fadeInLeft">
                                            <p class="date">06月10日</p>
                                        </div>
                                        <p class="dot-circle animated "><i class="fa fa-dot-circle-o"></i></p>
                                        <div class="content animated fadeInRight">优化WangEditor编辑器的使用，加入全屏编辑模式</div>
                                        <div class="clear"></div>
                                    </li>
                                </ul>
                            </div>
                            <div class="timeline-month">
                                <h3 class=" animated fadeInLeft"><a class="monthToggle" href="javascript:;">5月</a><i class="fa fa-caret-down fa-fw"></i></h3>
                                <ul>
                                    <li class=" ">
                                        <div class="h4  animated fadeInLeft">
                                            <p class="date">05月30日</p>
                                        </div>
                                        <p class="dot-circle animated "><i class="fa fa-dot-circle-o"></i></p>
                                        <div class="content animated fadeInRight">项目基本开发完成</div>
                                        <div class="clear"></div>
                                    </li>
                                    <li class=" ">
                                        <div class="h4  animated fadeInLeft">
                                            <p class="date">05月29日</p>
                                        </div>
                                        <p class="dot-circle animated "><i class="fa fa-dot-circle-o"></i></p>
                                        <div class="content animated fadeInRight">后端增加管理外链等模块</div>
                                        <div class="clear"></div>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        </div>
                        <h1 style="padding-top:4px;padding-bottom:2px;margin-top:40px;"><i class="fa fa-hourglass-end"></i>THE END</h1>
                    </div>
                </div>
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
            <a href="index"><i class="fa fa-home fa-fw"></i>&nbsp;网站首页</a>
        </li>
        <li class="layui-nav-item">
            <a href="articleCategory"><i class="fa fa-file-text fa-fw"></i>&nbsp;文章专栏</a>
        </li>
        <li class="layui-nav-item">
            <a href="resource"><i class="fa fa-tags fa-fw"></i>&nbsp;资源分享</a>
        </li>
        <li class="layui-nav-item">
            <a href="timeline"><i class="fa fa-road fa-fw"></i>&nbsp;点点滴滴</a>
        </li>
        <li class="layui-nav-item">
            <a href="about"><i class="fa fa-info fa-fw"></i>&nbsp;关于本站</a>
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
    <script src="plug/layui/layui.js"></script>
    <!-- 全局脚本 -->
    <script src="js/global.js"></script>
    <!-- 本页脚本 -->
    <script type="text/javascript">
        layui.use('jquery', function () {
            var $ = layui.jquery;

            $(function () {
                $('.monthToggle').click(function () {
                    $(this).parent('h3').siblings('ul').slideToggle('slow');
                    $(this).siblings('i').toggleClass('fa-caret-down fa-caret-right');
                });
                $('.yearToggle').click(function () {
                    $(this).parent('h2').siblings('.timeline-month').slideToggle('slow');
                    $(this).siblings('i').toggleClass('fa-caret-down fa-caret-right');
                });
            });
        });
    </script>
</body>
</html>