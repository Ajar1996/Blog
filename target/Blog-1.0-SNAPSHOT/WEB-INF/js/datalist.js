layui.define(['laypage', 'layer', 'form', 'pagesize'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        laypage = layui.laypage;
    var laypageId = 'pageNav';


    var page = 1, articleList, pageInfo;

    layui.use('laypage', function () {
        var laypage = layui.laypage;
        //执行一个laypage实例
        laypage.render({
            elem: 'pageNav' //注意，这里的 test1 是 ID，不用加 # 号
            , count:$("#total").val(),//数据总数，从服务端得到
            limit:8,
            jump: function (obj, first) {
                console.log($("#total").val());
                //obj包含了当前分页的所有参数，比如：
                /*console.log(obj.limit); //得到每页显示的条数*/
                //首次不执行
                        if (!first) {
                        $.ajax({
                                type: "get",
                                url: "ArticleList",
                                data:{pn:obj.curr},
                                contentType: "application/json; charset=utf-8",
                                success: function(data){
                                    articleList=data.list;
                                    pageInfo=data;
                                    initilData(page,articleList);
                                },
                                error: function(json){
                                    layer.msg("失败。");
                                }
                            });
                }
            }
        });
    });

    // 重写方法，自定义格式化日期
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

    //页数据初始化
    function initilData(currentIndex, articleList) {

        var index = layer.load(1);
        //模拟数据
        var data = articleList;

        //模拟数据加载
        setTimeout(function () {
            layer.close(index);
            //计算总页数（一般由后台返回）
            pages = pageInfo.pages;
            var html = '';  //由于静态页面，所以只能作字符串拼接，实际使用一般是ajax请求服务器数据
            html += '<table style="" class="layui-table" lay-even>';
            html += '<colgroup><col width="180"><col><col width="150"><col width="180"><col width="90"><col width="90"><col width="50"><col width="50"></colgroup>';
            html += '<thead><tr><th>发表时间</th><th>标题</th><th>作者</th><th>类别</th><th colspan="2">选项</th><th colspan="2">操作</th></tr></thead>';
            html += '<tbody>';
            //遍历文章集合
            for (var i = 0; i < data.length; i++) {
                var item = data[i];
                var datatime=new Date(item.articleCreateTime).toLocaleString();
                html += "<tr id='"+item.articleId+"'>";
                html += "<td>" + datatime; + "</td>";
                html += "<td>" + item.articleTitle + '[' + item.articleId + ']' + "</td>";
                html += "<td>" + item.articleUserId + "</td>";
                html += "<td>" + item.articleCategory + "</td>";
                html += '<td><form class="layui-form" action=""><div class="layui-form-item" style="margin:0;"><input type="checkbox" name="top" title="置顶" value="' + item.articleid + '" lay-filter="top" checked /></div></form></td>';
                html += '<td><form class="layui-form" action=""><div class="layui-form-item" style="margin:0;"><input type="checkbox" name="top" title="推荐" value="' + item.articleid + '" lay-filter="recommend" checked /></div></form></td>';
                html += '<td><button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.datalist.editData(\'' + item.articleId + '\')"><i class="layui-icon">&#xe642;</i></button></td>';
                html += '<td><button class="layui-btn layui-btn-small layui-btn-danger" onclick="layui.datalist.deleteData(\'' + item.articleId + '\')"><i class="layui-icon">&#xe640;</i></button></td>';
                html += "</tr>";
            }
            html += '</tbody>';
            html += '</table>';
            $('#dataContent').html(html);
            form.render('checkbox');  //重新渲染CheckBox，编辑和添加的时候
            $('#dataConsole,#dataList').attr('style', 'display:block'); //显示FiledBox
        }, 500);
    }

    //监听置顶CheckBox
    form.on('checkbox(top)', function (data) {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            if (data.elem.checked) {
                console.log()
                data.elem.checked = false;
            } else {
                data.elem.checked = true;
            }
            layer.msg('操作失败，返回原来状态');
            form.render();  //重新渲染
        }, 300);
    });

    //监听推荐CheckBox
    form.on('checkbox(recommend)', function (data) {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            layer.msg('操作成功');
        }, 300);
    });
    //添加数据
    $('#addArticle').click(function () {
        var index = layer.load(1);
        setTimeout(function () {

            layer.close(index);
            layer.msg('打开添加窗口');
        }, 500);
    });

    //输出接口，主要是两个函数，一个删除一个编辑
    var datalist = {
        deleteData: function (id) {
            layer.confirm('确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {

                $.ajax({
                    type: "get",
                    url: "ArticleDelete",
                    data:{articleId:id},
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
        editData: function (id) {
            layer.msg('编辑Id为【' + id + '】的数据');
            window.location.href="ArticleEdit?articleId="+id;
        }
    };
    exports('datalist', datalist);
});