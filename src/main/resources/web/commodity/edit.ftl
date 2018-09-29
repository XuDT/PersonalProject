<!DOCTYPE html>
<html lang="en">
<#include "../common/common.ftl" />
<body>
<form class="form-horizontal" id="editForm" enctype="multipart/form-data">
    <input  type="hidden" name="id" value="${(commodity.id)!}" size=85/>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品名称</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="name" value="${(commodity.name)!}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品规格</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="standard" value="${(commodity.standard)!}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">温度</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="temperature" value="${(commodity.temperature)!}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">价格</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="price" value="${(commodity.price)!}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品描述</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="description" value="${(commodity.description)!}">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input onclick="submitForm();" class="btn btn-default" value="提交">
        </div>
    </div>
</form>
<script>
    function submitForm() {
        $.ajax({
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/commodity/editCommodity",//url
            data: $('#editForm').serialize(),
            success: function (data) {
                if (data.success) {
                    layer.msg("提交成功!",
                            {icon:6,time:1000},
                            function(){
                                parent.reload();
                            })
                }
            },
            error: function () {
                my.alert("提交失败！");
            }
        });
    }
</script>
</body>
</html>