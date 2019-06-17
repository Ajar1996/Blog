<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>

<html >
<head>
    <link href="plug/layui/css/layui.css" rel="stylesheet" />
    <script src="plug/layui/layui.js"></script>
    <link href="css/index.css" rel="stylesheet" />
    <!-- 全局脚本 -->
    <script src="js/global.js"></script>
    <!-- 本页脚本 -->
    <script src="js/home.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>

    <script>
        $(document).ready(function(){
            $('#btn').click(function(e){
                e.preventDefault();
                if($("#userName").val()=="请输入用户名" || $("#userName").val()==""||$("#userPass").val()=="请输入密码"|| $("#userPass").val()==""){
                    $("#msg").html("用户名或密码不能为空！");
                    return false;
                }
                else {
                    $.ajax({
                        type:"post",
                        url:"checklogin",
                        data:{userName:$("#userName").val(),userPass:$("#userPass").val()},
                        success:function(data){
                            //判断输入是否成功，成功则跳转
                            if(data==true){
                                window.location.href="Admin/Main";
                            }else{
                                $("#msg").html("账号或密码错误");
                            }
                        }
                    });
                }
            })
        });
    </script>
</head>
<body>

<c:if test="${user!=null }">
    <c:redirect url="index"/>
</c:if>

<div>
    <canvas id="canvas-banner" style="position:relative; background: #393D49;"></canvas>
    <!--为了及时效果需要立即设置canvas宽高，否则就在home.js中设置-->
    <script type="text/javascript">
        var canvas = document.getElementById('canvas-banner');
        canvas.width = window.document.body.clientWidth - 10;//减去滚动条的宽度
        canvas.height = window.innerHeight;
    </script>
    <div class="layui-layer layui-layer-page pm-layer-login layer-anim-01" id="layui-layer9" type="page" times="9" showtime="0" contype="string" style="z-index: 19891023;width: 480px;height: 270px;top: 333.5px; left:700px;">
        <form class="layui-form">
            <div class="layui-layer-content" >
                <div class="layui-form-item">
                    <label class="layui-form-label" color>账号</label>
                    <div class="layui-input-inline pm-login-input">
                        <input type="text" id="userName"  name="userName" lay-verify="account" placeholder="请输入账号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline pm-login-input">
                        <input type="password" id="userPass" name="userPass" lay-verify="passWord" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <%--QQ登录图标--%>
                    <label class="layui-form-label"> <a href="qqlogin"><img src="images/qq_32.png"></a></label>
                    <div class="layui-input-block">
                        <h5 id="msg" style="color: #FD482C"></h5>
                    </div>
                </div>
                <div class="layui-form-item" style="margin-top:25px;margin-bottom:0;">
                    <div class="layui-input-block">
                        <button id="btn" class="layui-btn" style="width:230px;">立即登录</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>


</body>
</html>