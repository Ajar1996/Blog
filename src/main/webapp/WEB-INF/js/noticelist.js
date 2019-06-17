layui.define(['laypage', 'layer', 'form', 'pagesize'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        laypage = layui.laypage;


    //监听推荐CheckBox
    form.on('checkbox(publish)', function (id) {
        var index = layer.load(1);
        setTimeout(function () {
            $.ajax({
                type: "get",
                url: "NoticeStatus",
                data:{noticeId: id.value},
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (data==true)
                        layer.close(index);
                        layer.msg('操作成功');
                },
                error: function (json) {
                    layer.close(index);
                    form.render();
                    layer.msg('操作失败');
                }
            });
        }, 500);
    });

    var obj2,td_content;

    var datalist = {
        deleteData: function (id) {
            console.log(id);
            layer.confirm('确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                $.ajax({
                    type: "get",
                    url: "DeleteNotice",
                    data:{noticeId: id},
                    contentType: "application/json; charset=utf-8",
                    success: function(data){
                        if(data==true) {
                            layer.msg('删除Id为【' + id + '】的数据');
                            var tr1 = document.getElementById(id);
                            tr1.style.display = 'none';
                        }
                        if (data == false)
                            layer.msg("删除失败失败。");
                    },
                    error: function(json){
                        layer.msg("失败，系统异常");
                    }
                });
            }, function () {

            });
        },

        editData: function (obj,id) {
            obj2=obj;
            layer.msg('编辑Id为【' + id + '】的数据');

            td_content = $(obj).parents("tr").children("td");  //获取当前行中的所有td值

            var noticeId = td_content.eq(0).text(); //获取当前行第一个td的值

            var noticeTitle = td_content.eq(1).text(); //获取当前行第二个td的值
            var noticeContent = td_content.eq(2).text();


            var html="";
            html+="<div class=\"layui-form\" action=\"\">";
            html+="<br/> <div class=\"layui-form-item\">\n" +
                "                        <label class=\"layui-form-label\">序号</label>\n" +
                "                        <div class=\"layui-input-block\">\n" +
                "                            <input type=\"text\" name=\"noticeId\" disabled  value=\""+noticeId+"\">\n" +
                "                        </div>\n" +
                "                    </div>";
            html+="<div class=\"layui-form-item\">\n" +
                "                        <label class=\"layui-form-label\">标题</label>\n" +
                "                        <div class=\"layui-input-block\">\n" +
                "                            <input type=\"text\" name=\"noticeTitle\" required lay-verify=\"required\" placeholder=\"请输入标题\"\n" +
                "                                   autocomplete=\"off\" class=\"layui-input\" value=\""+noticeTitle+"\">\n" +
                "                        </div>\n" +
                "                    </div>";
            html+="<div class=\"layui-form-item layui-form-text\">\n" +
                "    <label class=\"layui-form-label\">普通文本域</label>\n" +
                "    <div class=\"layui-input-block\">\n" +
                "      <textarea placeholder=\"请输入内容\" name=\"noticeContent\" class=\"layui-textarea\">"+noticeContent+"</textarea>\n" +
                "    </div>\n" +
                "  </div>";
            html+="<div class=\"layui-form-item\">\n" +
                "                        <div class=\"layui-input-block\">\n" +
                "                            <button class=\"layui-btn\" lay-submit lay-filter=\"formDemo\">提交</button>\n" +
                "                        </div>\n" +
                "                    </div>";
            html+="</div>";
            layer.open({
                type: 1,
                title:'修改公告',
                skin: 'layui-layer-molv',
                area: ['800px', '360px'], //宽高
                content: html,
            });

        }
    };
    exports('datalist', datalist);

    /*监听修改广告*/
    form.on('submit(formDemo)', function (data) {
        var notice = data.field;
        $.ajax({
            type: "post",
            url: "UpdateNotice",
            data: JSON.stringify(notice),
            contentType: "application/json; charset=utf-8",
            success: function(data){
                if(data==true) {
                    layer.msg("修改成功");

                }
                else {
                    layer.msg("修改失败，请稍后再试...");
                }
            },
            error: function(json){
                layer.msg("修改失败，请稍后再试...");
            }
        });
    });

    /*监听添加广告*/
    form.on('submit(formDemo2)', function (data) {
        var notice = data.field;
        $.ajax({
            type: "post",
            url: "PublishNotice",
            data: JSON.stringify(notice),
            contentType: "application/json; charset=utf-8",
            success: function(data){
                if (data==true) {
                layer.msg("发布成功");
                window.location.reload();
                }
            },
            error: function(json){
                layer.msg("修改失败，请稍后再试...");
            }
        });
    });

    //添加数据
    $('#addNotice').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            var html="";
            html+="<div class=\"layui-form\" action=\"\">";
            html+="<div class=\"layui-form-item\">\n" +
                "                        <label class=\"layui-form-label\">标题</label>\n" +
                "                        <div class=\"layui-input-block\">\n" +
                "                            <input type=\"text\" name=\"noticeTitle\" required lay-verify=\"required\" placeholder=\"请输入标题\"\n" +
                "                                   autocomplete=\"off\" class=\"layui-input\">\n" +
                "                        </div>\n" +
                "                    </div>";
            html+="<div class=\"layui-form-item layui-form-text\">\n" +
                "    <label class=\"layui-form-label\">内容</label>\n" +
                "    <div class=\"layui-input-block\">\n" +
                "      <textarea placeholder=\"请输入内容\" name=\"noticeContent\" required class=\"layui-textarea\"></textarea>\n" +
                "    </div>\n" +
                "  </div>";
            html+="<div class=\"layui-form-item\">\n" +
                "                        <div class=\"layui-input-block\">\n" +
                "                            <button class=\"layui-btn\" lay-submit lay-filter=\"formDemo2\">提交</button>\n" +
                "                        </div>\n" +
                "                    </div>";
            html+="</div>";
            layer.open({
                type: 1,
                title:'修改公告',
                skin: 'layui-layer-molv',
                area: ['800px', '360px'], //宽高
                content: html,
            });
        }, 500);
    });


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