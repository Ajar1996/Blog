var editor;
layui.use(['element', 'form', 'layer'], function () {
    var form = layui.form;
    var element = layui.element;
    var layer = layui.layer;
    element.render();
    form.render();

    //监听提交
    form.on('submit(formDemo)', function (data) {
        var article=data.field;
        article.articleContent=editor.txt.html();
        $.ajax({
            type: "post",
            url: "publish",
            data: JSON.stringify(article),
          contentType: "application/json; charset=utf-8",
            success: function(data){
                if(data==true) {
                    layer.msg("发表成功");
                }
                else {
                    layer.msg("发表失败，请稍后再试...");
                }
            },
            error: function(json){
                layer.msg("发表失败，请稍后再试...");
            }
        });





        return false;
    });

    form.on('checkbox(tags)', function (data) {
        console.log(data.elem.title); //得到checkbox原始DOM对象
        console.log(data.elem.checked); //是否被选中，true或者false
        console.log(data.value); //复选框value值，也可以通过data.elem.value得到
        var checkedLength = $("div.tags ").find("input[lay-filter=tags]:checked").length;
        if (checkedLength > 4) {
            layer.open({
                title: '提示信息'
                , content: '最多4个，勾选多了也没用哦，请取消多余的！'
            });
        }
    });
});


$(function () {
    var E = window.wangEditor;
    editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
// 配置服务器端地址
    editor.customConfig.uploadImgServer = 'uploadImg';
    editor.customConfig.uploadFileName = 'myFileName';
    /* editor.customConfig.debug = location.href.indexOf('wangeditor_debug_mode=1') > 0 */

    // 进行下文提到的其他配置

    editor.customConfig.uploadImgTimeout = 30000;  //默认10秒

    editor.customConfig.uploadImgHooks = {
        before: function (xhr, editor, files) {
            // 图片上传之前触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件

            // 如果返回的结果是 {prevent: true, msg: 'xxxx'} 则表示用户放弃上传
            // return {
            //     prevent: true,
            //     msg: '放弃上传'
            // }
        },
        success: function (xhr, editor, result) {
            // 图片上传并返回结果，图片插入成功之后触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果

            /* alert("success:" + result); */
            /*  alert(eval('(' + result + ')')); */
        },
        fail: function (xhr, editor, result) {
            // 图片上传并返回结果，但图片插入错误时触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
            layer.msg("上传成功");
        },
        error: function (xhr, editor) {
            // 图片上传出错时触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
        },
        timeout: function (xhr, editor) {
            // 图片上传超时时触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
        },

        // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
        // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
        customInsert: function (insertImg, result, editor) {
            // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
            // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

            // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
            var url = result.url;
            insertImg(url);

            // result 必须是一个 JSON 格式字符串！！！否则报错

        }
    };
    editor.create();
    E.fullscreen.init('#editor');
    var json = editor.txt.getJSON();
});