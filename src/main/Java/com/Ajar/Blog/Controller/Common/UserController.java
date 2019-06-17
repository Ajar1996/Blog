package com.Ajar.Blog.Controller.Common;

import com.Ajar.Blog.Pojo.User;
import com.Ajar.Blog.Service.UserService;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    User user;

    @RequestMapping("/login")
    public  String Login(){
        return "Common/login";
    }

    @ResponseBody
    @RequestMapping("/checklogin")
    public Boolean CheckLogin(User getuser, Model model, HttpServletRequest request){
        user=userService.CheckUser(getuser);
        if(user.getUserName()==null){
            return false;
        }
        else {
            userService.UpdateLoginTime(user);
            model.addAttribute("user", user);
            request.getSession().setAttribute("user",user);
            return true;
        }
    }
    @RequestMapping("/qqlogin")
    public void QQLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        try {
            /* String authorizeURL = new Oauth().getAuthorizeURL(request);*/
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/afterqqlogin",method= RequestMethod.GET)
    public String AfterQQLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
            String accessToken   = null,
                    openID        = null;
            long tokenExpireIn = 0L;
            if (accessTokenObj.getAccessToken().equals("")) {
                System.out.print("没有获取到响应参数");
            }else{
                accessToken = accessTokenObj.getAccessToken();
                tokenExpireIn = accessTokenObj.getExpireIn();
                OpenID openIDObj =  new OpenID(accessToken);
                openID = openIDObj.getUserOpenID();
                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                HttpSession session=request.getSession();
                session.setAttribute("name", userInfoBean.getNickname());
                session.setAttribute("avatar", userInfoBean.getAvatar().getAvatarURL30());

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Home/qq";
    }






}
