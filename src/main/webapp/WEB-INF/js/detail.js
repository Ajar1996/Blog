
prettyPrint();

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

layui.use(['form', 'layedit'], function () {
    var form = layui.form;
    var $ = layui.jquery;
    var layedit = layui.layedit;

    //评论和留言的编辑器
    var editIndex = layedit.build('remarkEditor', {
        height: 150,
        tool: ['face', '|', 'left', 'center', 'right', '|', 'link'],
    });
    //评论和留言的编辑器的验证
    layui.form.verify({
        content: function (value) {
            value = $.trim(layedit.getText(editIndex));
            if (value == "") return "自少得有一个字吧";
            layedit.sync(editIndex);
        }
    });

    //监听评论提交
    form.on('submit(formRemark)', function (data) {
        var user=$("#username").val();
        /*
        如果没登录，就评论失败
         */
        if(user==""){
            layer.msg("评论失败，您尚未登录...");
        }
        /*
        登录成功，用Ajax进行交互
         */
        else {
        var index = layer.load(1);
        var content = data.field.editorContent;
        console.log($("#username").val());
        var comment={commentContent:content,commentArticleId:$("#articleId").val(),commentAuthorName:$("#username").val()};
            $.ajax({
                type: "post",
                url: "../commentArticle",
                data: JSON.stringify(comment),
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (data != null) {
                        setTimeout(function () {
                            layer.close(index);
                            var html = '<li><div class="comment-parent"><img src="../images/Absolutely.jpg"alt="absolutely"/><div class="info"><span class="username">'+data.commentAuthorName+'</span><span class="time">'+new Date(data.commentCreateTime).toLocaleString()+'</span></div><div class="content">' + data.commentContent + '</div></div></li>';
                            $('.blog-comment').append(html);
                            $('#remarkEditor').val('');
                            editIndex = layui.layedit.build('remarkEditor', {
                                height: 150,
                                tool: ['face', '|', 'left', 'center', 'right', '|', 'link'],
                            });
                            layer.msg("评论成功", {icon: 1});
                        }, 500);
                    }
                },
                error: function (json) {
                    layer.msg("系统错误，请稍后再试...");
                }
            });
        }
        return false;
    });
});