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
    <title>Ajar博客 - 关于本站</title>
    <link rel="shortcut icon" href="../images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="plug/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="css/about.css" rel="stylesheet" />
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
                    <a href="timeline"><i class="fa fa-hourglass-half fa-fw"></i>&nbsp;点点滴滴</a>
                </li>
                <li class="layui-nav-item layui-this">
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
                <a><cite>关于本站</cite></a>
            </blockquote>
            <div class="blog-main">
                <div class="layui-tab layui-tab-brief shadow" lay-filter="tabAbout">
                    <ul class="layui-tab-title">
                        <li lay-id="1">关于博客</li>
                        <li lay-id="2">关于作者</li>
                        <li lay-id="3" id="frinedlink">友情链接</li>
                        <li lay-id="4">留言墙</li>
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item">
                            <div class="aboutinfo">
                                <div class="aboutinfo-figure">
                                    <img src="images/Logo_100.png" alt="不落阁" />
                                </div>
                                <p class="aboutinfo-nickname">Interesting的小店</p>
                                <p class="aboutinfo-introduce">一个JAVA程序员的个人博客，记录博主学习和成长之路，分享JAVA方面技术和源码</p>
                                <p class="aboutinfo-location"><i class="fa fa-link"></i>&nbsp;&nbsp;<a target="_blank" href="http://www.interesting1996.shop">www.interesting1996.shop</a></p>
                                <hr />
                                <div class="aboutinfo-contact">
                                    <a target="_blank" title="网站首页" href="home"><i class="fa fa-home fa-2x" style="font-size:2.5em;position:relative;top:3px"></i></a>
                                    <a target="_blank" title="文章专栏" href="article"><i class="fa fa-file-text fa-2x"></i></a>
                                    <a target="_blank" title="资源分享" href="resource"><i class="fa fa-tags fa-2x"></i></a>
                                    <a target="_blank" title="点点滴滴" href="timeline"><i class="fa fa-hourglass-half fa-2x"></i></a>
                                </div>

                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>简介</legend>
                                    <div class="layui-field-box aboutinfo-abstract">
                                        <p style="text-align:center;">不落阁是一个由Spring+SpirngMVC+Mybatis开发的个人博客网站，诞生于2019年6月1日</p>
                                        <h1>前端</h1>
                                        <p>在github上找到的一个静态的模板后，自己进行了修改，改成了如今的动态页面。网页用到Layui框架，这个框架非常容易上手，而且也非常简洁。</p>
                                        <h1>后端</h1>
                                        <p>在后台用的是SSM框架，用Ajax和Json进行前后端交互。</p>
                                        <h1>当前版本</h1>
                                        <p>还有挺多模块没有开发完成，现在正在持续完善中...</p>
                                        <h1 style="text-align:center;">The End</h1>
                                    </div>
                                </fieldset>
                            </div>
                        </div><!--关于网站End-->
                        <div class="layui-tab-item">
                            <div class="aboutinfo">
                                <div class="aboutinfo-figure">
                                    <img src="images/Absolutely.jpg" alt="Absolutely" />
                                </div>
                                <p class="aboutinfo-nickname">Ajar</p>
                                <p class="aboutinfo-introduce">一枚90后程序员，JAVA开发工程师，熟悉后端知识，比较了解WEB前端</p>
                                <p class="aboutinfo-location"><i class="fa fa-location-arrow"></i>&nbsp;广东 - 广州</p>
                                <hr />
                                <div class="aboutinfo-contact">
                                    <a target="_blank" title="QQ交流" href="javascript:layer.msg('启动QQ会话窗口')"><i class="fa fa-qq fa-2x"></i></a>
                                    <a target="_blank" title="给我写信" href="javascript:layer.msg('启动邮我窗口')"><i class="fa fa-envelope fa-2x"></i></a>
                                    <a target="_blank" title="新浪微博" href="javascript:layer.msg('转到你的微博主页')"><i class="fa fa-weibo fa-2x"></i></a>
                                    <a target="_blank" title="码云" href="javascript:layer.msg('转到你的github主页')"><i class="fa fa-git fa-2x"></i></a>
                                </div>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>简介</legend>
                                    <div class="layui-field-box aboutinfo-abstract abstract-bloger">
                                        <p style="text-align:center;">Ajar，就读于吉林大学珠海学院，诞生于1997年1月22日，目前是一个无业游民。</p>
                                        <h1>个人信息</h1>
                                        <p>暂无</p>
                                        <h1>个人介绍</h1>
                                        <p>一个没有故事的男同学，没什么介绍......</p>
                                        <h1 style="text-align:center;">The End</h1>
                                    </div>
                                </fieldset>
                            </div>
                        </div><!--关于作者End-->
                        <div class="layui-tab-item">
                            <div class="aboutinfo">
                                <div class="aboutinfo-figure">
                                    <img src="images/handshake.png" alt="友情链接" />
                                </div>
                                <p class="aboutinfo-nickname">友情链接</p>
                                <p class="aboutinfo-introduce">Name：Interesting的小店&nbsp;&nbsp;&nbsp;&nbsp;Site：www.interesting1996.shop</p>
                                <p class="aboutinfo-location">
                                    <i class="fa fa-close"></i>经常宕机&nbsp;
                                    <i class="fa fa-close"></i>不合法规&nbsp;
                                    <i class="fa fa-close"></i>插边球站&nbsp;
                                    <i class="fa fa-close"></i>红标报毒&nbsp;
                                    <i class="fa fa-check"></i>原创优先&nbsp;
                                    <i class="fa fa-check"></i>技术优先
                                </p>
                                <hr />
                                <div class="aboutinfo-contact">
                                    <p style="font-size:2em;">互换友链，携手并进！</p>
                                </div>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>Friend Link</legend>
                                    <div class="layui-field-box">
                                        <ul class="friendlink">
                                            <c:forEach items="${linkList}" var="link">
                                            <li>
                                                <a target="_blank" href="http://${link.linkUrl}/" title="Layui" class="friendlink-item">
                                                    <p class="friendlink-item-pic"><img src="http://www.layui.com/favicon.ico" alt="Layui" /></p>
                                                    <p class="friendlink-item-title">${link.linlName}</p>
                                                    <p class="friendlink-item-domain">${link.linkUrl}</p>
                                                </a>
                                            </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </fieldset>
                            </div>
                        </div><!--友情链接End-->
                        <div class="layui-tab-item">
                            <div class="aboutinfo">
                                <div class="aboutinfo-figure">
                                    <img src="images/messagewall.png" alt="留言墙" />
                                </div>
                                <p class="aboutinfo-nickname">留言墙</p>
                                <p class="aboutinfo-introduce">本页面可留言、吐槽、提问。欢迎灌水，杜绝广告！</p>
                                <p class="aboutinfo-location">
                                    <i class="fa fa-clock-o"></i>&nbsp;<span id="time"></span>
                                </p>
                                <hr />
                                <div class="aboutinfo-contact">
                                    <p style="font-size:2em;">沟通交流，拉近你我！</p>
                                </div>
                                <fieldset class="layui-elem-field layui-field-title">
                                    <legend>Leave a message</legend>
                                    <div class="layui-field-box">
                                        <div class="leavemessage" style="text-align:initial">
                                            <form class="layui-form blog-editor" action="">
                                                <div class="layui-form-item">
                                                    <textarea name="editorContent" lay-verify="content" id="remarkEditor" placeholder="请输入内容" class="layui-textarea layui-hide"></textarea>
                                                </div>
                                                <div class="layui-form-item">
                                                    <button class="layui-btn" lay-submit="formLeaveMessage" lay-filter="formLeaveMessage">提交留言</button>
                                                </div>
                                            </form>
                                            <ul class="blog-comment">
                                                <li>
                                                    <div class="comment-parent">
                                                        <img src="images/Logo_40.png" alt="不落阁" />
                                                        <div class="info">
                                                            <span class="username">BOLG</span>
                                                        </div>
                                                        <div class="content">
                                                            模拟留言与回复！开发中。
                                                        </div>
                                                        <p class="info info-footer"><span class="time">2017-03-18 18:09</span><a class="btn-reply" href="javascript:;" onclick="btnReplyClick(this)">回复</a></p>
                                                    </div>
                                                    <hr />
                                                    <div class="comment-child">
                                                        <img src="images/Absolutely.jpg" alt="Absolutely" />
                                                        <div class="info">
                                                            <span class="username">Absolutely</span><span>这是用户回复内容</span>
                                                        </div>
                                                        <p class="info"><span class="time">2017-03-18 18:26</span></p>
                                                    </div>
                                                    <div class="comment-child">
                                                        <img src="images/Absolutely.jpg" alt="Absolutely" />
                                                        <div class="info">
                                                            <span class="username">Absolutely</span><span>这是第二个用户回复内容</span>
                                                        </div>
                                                        <p class="info"><span class="time">2017-03-18 18:26</span></p>
                                                    </div>
                                                    <!-- 回复表单默认隐藏 -->
                                                    <div class="replycontainer layui-hide">
                                                        <form class="layui-form" action="">
                                                            <div class="layui-form-item">
                                                                <textarea name="replyContent" lay-verify="replyContent" placeholder="请输入回复内容" class="layui-textarea" style="min-height:80px;"></textarea>
                                                            </div>
                                                            <div class="layui-form-item">
                                                                <button class="layui-btn layui-btn-mini" lay-submit="formReply" lay-filter="formReply">提交</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </fieldset>
                            </div>
                        </div><!--留言墙End-->
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
    <script src="js/about.js"></script>
</body>
</html>