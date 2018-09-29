var my={};
$(function () {
    //提示框
    my.alert = function(msg,title){
        if(msg == undefined){
            msg = "";
        }
        if(title == undefined){
            title = "提示";
        }
        layer.alert(msg,{
            skin: 'layui-layer-molv' //样式类名
            ,closeBtn: 1,
            shade: false, //点击遮罩关闭层
            title : [title , true]
        });
    };
    //弹出框
    my.confirm = function(tit,msg,conYes){
        layer.confirm(msg,{shade: false,title:tit,icon:3},conYes);
    };
    //弹窗
    my.open = function(options){
        if(options.success == undefined){
            options.success = function(layero){
                layer.setTop(layero);//置顶
            };
        }
        var index = layer.open({
            type: 2,//iframe层
            title: options.title,
            closeBtn: options.closeBtn, //不显示关闭按钮
            shadeClose: true,
            shade: false,
            zIndex: layer.zIndex,
            maxmin: options.maxmin, //开启最大化最小化按钮
            area: [options.width+"px", options.height+"px"],
            content: options.url|| options.html,
            btn: options.btn,
            yes:options.yes,//【按钮一】的回调
            cancel:options.cancel,//按钮【按钮二】的回调
            btn3:options.btn3,
            btn4:options.btn4,
            success: options.success//成功后的回调
        });
        return index;
    };
    //关闭弹出层
    my.close =  function(){
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    };
});