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
    <meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>Ajar - 一个JAVA程序员的个人博客网站</title>
    <link rel="shortcut icon" href="images/Logo_40.png" type="image/x-icon">
    <!--Layui-->
    <link href="plug/layui/css/layui.css" rel="stylesheet"  media="all"/>
    <!--font-awesome-->
    <link href="plug/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="css/home.css" rel="stylesheet" />

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


            <!-- 不落阁 -->
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
        <!-- canvas -->
        <canvas id="canvas-banner" style="background: #393D49;"></canvas>
        <!--为了及时效果需要立即设置canvas宽高，否则就在home.js中设置-->
        <script type="text/javascript">
            var canvas = document.getElementById('canvas-banner');
            canvas.width = window.document.body.clientWidth - 10;//减去滚动条的宽度
            if (screen.width >= 992) {
                canvas.height = window.innerHeight * 1 / 3;
            } else {
                canvas.height = window.innerHeight * 2 / 7;
            }
        </script>
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
            <div class="blog-main">
                <!-- 网站公告提示 -->
                <div class="home-tips shadow">
                    <i style="float:left;line-height:17px;" class="fa fa-volume-up"></i>
                    <div class="home-tips-container">
                        <c:forEach items="${noticeList}" var="notice">
                            <span style="color: #009688">${notice.noticeTitle}:${notice.noticeContent}</span>
                        </c:forEach>
                        <%--<span style="color: red">希望大家喜欢0.0<a href="#" target="_blank" style="color:#01AAED">点我前往</a></span>
                        <span style="color: #009688">Ajar 个人学习网站</span>--%>
                    </div>
                </div>
                <!--左边文章列表-->
                <div class="blog-main-left">
                    <c:forEach items="${pageInfo.list}" var="article">
                    <div class="article shadow">
                        <div class="article-left">
                            <img src="images/cover/201703181909057125.jpg" alt="基于laypage的layui扩展模块（pagesize.js）！" />
                        </div>
                        <div class="article-right">
                            <div class="article-title">
                            <a href="article/${article.articleId}">${article.articleTitle}</a>
                            </div>
                            <div class="article-abstract">
                                    ${article.articleSummary}
                            </div>
                        </div>
                        <div class="clear"></div>
                        <div class="article-footer">
                            <span><i class="fa fa-clock-o">
                            </i>&nbsp;&nbsp;<fmt:formatDate value="${article.articleCreateTime}" pattern="yyyy年MM月dd日"/></span>
                            <span class="article-author"><i class="fa fa-user"></i>Ajar</span>
                            <span><i class="fa fa-tag"></i><a href="#">${article.articleCategory}</a></span>
                            <span class="article-viewinfo"><i class="fa fa-eye"></i>${article.articleViewCount}</span>
                            <span class="article-viewinfo"><i class="fa fa-commenting"></i>${article.articleCommentCount}</span>
                        </div>
                    </div>
                    </c:forEach>

                    <%--分页--%>
                   <div class="layui-box layui-laypage layui-laypage-default" >
                        <!--点击分页-->
                                   <%--<a href="index?pn=1" class="prebtn">首页</a>--%>
                                    <!--上一页-->
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <a href="index?pn=${pageInfo.pageNum-1}" class="layui-laypage-prev">上一页</a>
                                        </c:if>
                                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                                        <c:if test="${page_num == pageInfo.pageNum}">
                                            <span class="layui-laypage-curr"><em class="layui-laypage-em"></em><em>${page_num}</em></span>
                                        </c:if>
                                        <c:if test="${page_num != pageInfo.pageNum}">
                                            <a href="index?pn=${page_num}" class="zxfPagenum">${page_num}</a>
                                        </c:if>
                                    </c:forEach>

                                    <!--下一页-->

                                        <c:if test="${pageInfo.hasNextPage}">
                                            <a href="index?pn=${pageInfo.pageNum+1}"
                                               class="layui-laypage-next">
                                                下一页
                                            </a>
                                        </c:if>


                                    <%--<a href="index?pn=${pageInfo.pages}">尾页</a>
--%>
                       <!--文字信息-->
                       <span>
                           当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
                       </span>


                    </div>

                </div>
                <!--右边小栏目-->
                <div class="blog-main-right">
                    <div class="blogerinfo shadow">
                        <div class="blogerinfo-figure">
                            <img src="images/Absolutely.jpg" alt="Absolutely" />
                        </div>
                        <p class="blogerinfo-nickname">Ajar</p>
                        <p class="blogerinfo-introduce">一枚90后程序员，JAVA开发工程师</p>
                        <p class="blogerinfo-location"><i class="fa fa-location-arrow"></i>&nbsp;广东-珠海</p>
                        <hr />
                        <div class="blogerinfo-contact">
                            <a target="_blank" title="QQ交流" href="javascript:layer.msg('启动QQ会话窗口')"><i class="fa fa-qq fa-2x"></i></a>
                            <a target="_blank" title="给我写信" href="javascript:layer.msg('启动邮我窗口')"><i class="fa fa-envelope fa-2x"></i></a>
                            <a target="_blank" title="新浪微博" href="javascript:layer.msg('转到你的微博主页')"><i class="fa fa-weibo fa-2x"></i></a>
                            <a target="_blank" title="码云" href="javascript:layer.msg('转到你的github主页')"><i class="fa fa-git fa-2x"></i></a>
                        </div>
                    </div>
                    <div></div><!--占位-->
                    <div class="blog-module shadow">
                        <div class="blog-module-title">热文排行</div>
                        <ul class="fa-ul blog-module-ul">
                            <c:forEach items="${hotArticle}" var="article" end="7">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="article/${article.articleId}">${article.articleTitle}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">最近分享</div>
                        <ul class="fa-ul blog-module-ul">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="http://pan.baidu.com/s/1c1BJ6Qc" target="_blank">Canvas</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="http://pan.baidu.com/s/1kVK8UhT" target="_blank">pagesize.js</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="https://pan.baidu.com/s/1mit2aiW" target="_blank">时光轴</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="https://pan.baidu.com/s/1nuAKF81" target="_blank">图片轮播</a></li>
                        </ul>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">一路走来</div>
                        <dl class="footprint">
                            <dt>2019年06月13日</dt>
                            <dd>Ajar博客1.0基本功能完成，正式上线！</dd>
                        </dl>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">后台记录</div>
                        <dl class="footprint">
                            <dt>2019年06月10日</dt>
                            <dd>WangEditor加入全屏编辑模式</dd>
                            <dt>2019年05月29日</dt>
                            <dd>后端增加管理外链等模块</dd>
                        </dl>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">友情链接</div>
                        <ul class="blogroll">
                            <c:forEach items="${linkList}" var="link">
                            <li><a target="_blank" href="http://${link.linkUrl}/" title="${link.linlName}">${link.linlName}</a></li>
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
    <script type="text/javascript" src="plug/layui/layui.js"></script>
    <!-- 全局脚本 -->
    <script src="js/global.js"></script>
    <!-- 本页脚本 -->
    <script src="js/home.js"></script>
</body>
</html>