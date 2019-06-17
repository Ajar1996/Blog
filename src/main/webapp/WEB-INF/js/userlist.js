layui.define(['laypage', 'layer', 'form', 'pagesize'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        laypage = layui.laypage;

var userList,pageInfo;
$(function()
{
    $.ajax({
        type: "get",
        url: "getAllUser",
        data:{pn: 1},
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            userList=data.list;
            pageInfo=data;
            insert(userList);
        },
        error: function (json) {
           console.log("123");
        }
    });
});


function insert(UserList){
    var insertText ="";
    insertText+=" <table style=\"\" class=\"layui-table\" lay-even=\"\">\n" +
        "                <colgroup>\n" +
        "                    <col width=\"100\">\n" +
        "                    <col width=\"150\">\n" +
        "                    <col width=\"180\">\n" +
        "                    <col width=\"180\">\n" +
        "                    <col>\n" +
        "                    <col width=\"200\">\n" +
        "                    <col width=\"200\">\n" +
        "                    <col width=\"90\">\n" +
        "                    <col width=\"90\">\n" +
        "                    <col width=\"50\">\n" +
        "                    <col width=\"50\">\n" +
        "                </colgroup>\n" +
        "                <thead>\n" +
        "                <tr>\n" +
        "                    <th>序号</th>\n" +
        "                    <th>昵称</th>\n" +
        "                    <th>账号</th>\n" +
        "                    <th>密码</th>\n" +
        "                    <th>邮箱</th>\n" +
        "                    <th>注册时间</th>\n" +
        "                    <th>登录时间</th>\n" +
        "                    <th colspan=\"2\">选项</th>\n" +
        "                    <th colspan=\"2\">操作</th>\n" +
        "                </tr>\n" +
        "                </thead>\n" +
        "                <tbody>";
    for (var i = 0; i < UserList.length; i++) {
        var User = UserList[i];
        var RegisterTime=new Date(User.userRegisterTime).toLocaleString();
        var LastLoginTime=new Date(User.userLastLoginTime).toLocaleString();


        insertText+="<tr>\n" +
            "                        <td>"+User.userId+"</td>\n" +
            "                        <td>"+User.userNickname+"</td>\n" +
            "                        <td>"+User.userName+"</td>\n" +
            "                        <td>"+User.userPass+"</td>\n" +
            "                        <td>"+User.userEmail+"</td>\n" +
            "                        <td>"+RegisterTime+"</td>\n" +
            "                        <td>"+LastLoginTime+"</td>\n" +
            "                        <td>\n" +
            "                            <form class=\"layui-form\" action=\"\">\n" +
            "                                <div class=\"layui-form-item\" style=\"margin:0;\">\n" +
            "                                    <input type=\"checkbox\" name=\"top\" title=\"置顶\" value=\""+User.userId+"\" lay-filter=\"top\" checked>\n" +
            "                                </div>\n" +
            "                            </form>\n" +
            "                        </td>\n" +
            "                        <td>\n" +
            "                            <form class=\"layui-form\" action=\"\">\n" +
            "                                <div class=\"layui-form-item\" style=\"margin:0;\">\n" +
            "                                    <input type=\"checkbox\" name=\"top\" title=\"推荐\"  value=\""+User.userId+"\" lay-filter=\"recommend\" checked>\n" +
            "                                </div>\n" +
            "                            </form>\n" +
            "                        </td>\n" +
            "                        <td>\n" +
            "                            <button class=\"layui-btn layui-btn-small layui-btn-normal\"><i class=\"layui-icon\">&#xe642;</i></button>\n" +
            "                        </td>\n" +
            "                        <td>\n" +
            "                            <button class=\"layui-btn layui-btn-small layui-btn-danger\"><i class=\"layui-icon\">&#xe640;</i></button>\n" +
            "                        </td>\n" +
            "                    </tr>";

    }
         insertText+="</tbody>\n" +"            </table>";
    $('#insert').html(insertText);

}

Date.prototype.toLocaleString = function() {
    // 补0   例如 2018/7/10 14:7:2  补完后为 2018/07/10 14:07:02
    function addZero(num) {
        if(num<10)
            return "0" + num;
        return num;
    }
    // 按自定义拼接格式返回
    return this.getFullYear() + "年" + addZero(this.getMonth() + 1) + "月" + addZero(this.getDate()) + "日"/*+
            addZero(this.getHours()) + "时" + addZero(this.getMinutes()) + "分" + addZero(this.getSeconds()+"秒")*/;
};

});