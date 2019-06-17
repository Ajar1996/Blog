
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

/*插入搜索内容*/
function insert(articleList){
    if (articleList.length==0){
        var insertText ="<div className=\"shadow\"\n" +
            "             style=\"text-align:center;font-size:16px;padding:40px 15px;background:#fff;margin-bottom:15px;\">\n" +
            "            未搜索到与【<span style=\"color: #FF5722;\">"+$("#keywords").val()+"</span>】有关的文章，随便看看吧！\n" +
            "        </div>";
        $('#insert').html(insertText);
    }
    else {
        var insertText ="";
        for (var i = 0; i < articleList.length; i++) {
            var article = articleList[i];
            var data2=new Date(article.articleCreateTime);
            var datatime=data2.toLocaleString();
            insertText+="<div class=\"article shadow\">\n" +
                "                            <div class=\"article-left\">\n" +
                "                                <img src=\"images/cover/201703181909057125.jpg\" alt=\"基于laypage的layui扩展模块（pagesize.js）！\" />\n" +
                "                            </div>\n" +
                "                            <div class=\"article-right\">\n" +
                "                                <div class=\"article-title\">\n" +
                "                                   <a href=\"article/"+article.articleId+"\">"+article.articleTitle+"</a>" +
                "                                </div>\n" +
                "                                <div class=\"article-abstract\">\n" +
                "                                        "+article.articleSummary+"\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"clear\"></div>\n" +
                "                            <div class=\"article-footer\">\n" +
                "                            <span><i class=\"fa fa-clock-o\">\n" +
                "                            </i>&nbsp;&nbsp;"+datatime+"</span>\n" +
                "                                <span class=\"article-author\"><i class=\"fa fa-user\"></i>&nbsp;&nbsp;"+article.articleUserId+"</span>\n" +
                "                                <span><i class=\"fa fa-tag\"></i>&nbsp;&nbsp;<a href=\"#\">"+article.articleCategory+"</a></span>\n" +
                "                                <span class=\"article-viewinfo\"><i class=\"fa fa-eye\"></i>"+article.articleViewCount+"</span>\n" +
                "                                <span class=\"article-viewinfo\"><i class=\"fa fa-commenting\"></i>"+article.articleCommentCount+"</span>\n" +
                "                            </div>\n" +
                "                        </div>";
            $('#insert').html(insertText);
        }
    }
};

$(function () {
    /*搜索*/
    $("#search").click(
        function() {
            if($("#keywords").val()!="") {
                $.ajax({
                    type: "get",
                    url: "SearchArticle",
                    data: {title: $("#keywords").val()},
                    contentType: "application/json; charset=utf-8",
                    success: function (data) {
                        insert(data)
                    },
                    error: function (json) {
                        layer.msg("搜索失败...");
                    }
                });
            }
            else
                layer.msg("请输入关键字");
        }
    )
    /*分类切换交互*/
    $(".categoryId").click(function () {
        var category=$(this).html();
        $.ajax({
            type: "post",
            url: "CategoryArticle",
            data:  JSON.stringify({articleCategory: category}),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                layer.msg("切换到"+category);
                insert(data);
            },
            error: function (json) {
                layer.msg("切换失败...");
            }
        });
    })
























});

