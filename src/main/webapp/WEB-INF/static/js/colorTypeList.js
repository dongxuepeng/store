$(function(){
    $.ajax({
        url:'/store/type/goods/',
        type:'POST',
        async: false,
        data:{aa:"aa"},
        success:function (msg) {
            var queryGoods = $("#queryGoodsId");
            var goods = $("#goodsTypeId");
            queryGoods.append("<option value=''>直接选择或搜索选择</option>");
            var data = msg.data;
            for(var i=0;i<data.length;i++){
                queryGoods.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                goods.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
            }
        },
        error:function(data){
        }
    });
});
layui.use(['table','form'], function(){
    var table = layui.table;
    var form = layui.form;
    table.render({
        elem: '#test'
        ,url:'/store/type/color/'
        ,toolbar: '#toolbarDemo'
        ,title: '颜色列表'
        ,cols: [[
            {type: 'checkbox', fixed: 'left',width:'5%'}
            ,{field:'id', title:'ID', width:'15%', fixed: 'left', unresize: true, sort: true}
            ,{field:'name', title:'颜色名称', width:'30%'}
            ,{field:'goods', title:'所属商品', width:'30%'}
            ,{field:'goodsId', title:'所属商品Id', width:'0%'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'20%'}
        ]],
        done:function(res,curr,count){
            $("[data-field='goodsId']").css('display','none');
        }
        ,id: 'testReload'
        ,page: true,
        height:parent.ifreamHeight - 50
    });
    //查询
    $("#queryBtn").on("click",function(){
        var id = $("#queryId").val();
        if(id != "" && isNaN(id)){
            layer.msg("主键值请输入数字！");
            $("#queryId").val("");
            return;
        }
        var name = $("#queryName").val();
        var goodsType = $("#queryGoodsId").val() == '-1' ? "" : $("#queryGoodsId").val();
        reloadTableData(id,name,goodsType);
    });
    //重置
    $("#clearBtn").on("click",function(){
        $("#queryId").val("");
        $("#queryName").val("");
        $("#queryGoodsId").val("");
        //changeSelectValue("queryGoodsId","");
        form.render();
        reloadTableData($("#queryId").val(),$("#queryName").val(),"");
    });
    //刷新表数据
    function reloadTableData(id,name,goodsType){
        table.reload("testReload",{
            url:"/store/type/color/",
            where:{
                id:id,
                name:name,
                goodsType:goodsType
            },
            page:{curr:1}
        },'data');
    }
    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'addItem':
                openDivPage("add","");
                break;
            case 'delSelect':
                var data = checkStatus.data;
                var idsArr = new Array();
                for(var i=0;i<data.length;i++){
                    idsArr.push(data[i].id);
                }
                if(idsArr.length == 0){
                    layer.msg('请选择记录', {icon: 5});
                    return false;
                }
                delGoodsTypeData(idsArr.join(","));
                break;
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm('确定删除【'+data.name+'】吗？', {
                btn: ['删除','取消']
            }, function(){
                delGoodsTypeData(data.id);
            }, function(){

            });
        } else if(obj.event === 'edit'){
            openDivPage("edit",data);
        }
    });
    function openDivPage(type,data){
        layer.open({
            //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
            type: 1,
            title: type == 'edit' ? "【修改】颜色信息" : "【新增】颜色信息",
            area: ['400px', '500px'],
            content: $("#dataDiv"),//引用的弹出层的页面层的方式加载修改界面表单
            btn:['保存','取消'],
            yes:function (index,layero) {
                saveGoodsTypeData(index,
                    type == 'edit' ?'/store/type/updateColorType/':'/store/type/addColorType/',
                    type == 'edit' ?"修改成功":"新增成功",
                    type == 'edit' ?"修改失败":"新增失败");

            },
            success:function(layero,index){
                var typeId = type == 'edit' ? data.id :'自动生成';
                var typeName = type == 'edit' ? data.name:"";
                var goods = type == 'edit' ? data.goodsId:"";
                $("#typeId").val(typeId);
                $("#typeName").val(typeName);
                $("#goodsTypeId").val(goods);
                //changeSelectValue("goodsTypeId",goods);
                form.render();
            },
            btn2:function (index,layero) {
                reloadTableData($("#queryId").val(),$("#queryName").val(),$("#queryGoodsId").val());
            }
        });
    }
    function saveGoodsTypeData(index,url,succMsg,errorMsg){
        var name = $("#typeName").val();
        if(name == ''){
            layer.msg('名称不能为空', {icon: 5});
            return false;
        }
        var goods = $("#goodsTypeId").val();
        if(goods == ''){
            layer.msg('所属商品不能为空', {icon: 5});
            return false;
        }
        var count = -1;
        $.ajax({
            url:'/store/type/checkColorName/',
            type:'POST',
            async: false,
            data:{id:$("#typeId").val(),name:$("#typeName").val(),goods:goods},
            success:function (msg) {
                count = msg;
            },
            error:function(data){
                console.info(data);
            }
        });
        if(count > 0){
            layer.msg('该商品已存在【'+name+'】!', {icon: 5});
            return false;
        }
        $.ajax({
            url:url,
            type:'POST',
            data:{id:$("#typeId").val(),name:$("#typeName").val(),goods:goods},
            success:function (msg) {
                if(msg > 0){
                    layer.close(index);
                    layer.msg(succMsg);
                    setTimeout(function(){
                        reloadTableData($("#queryId").val(),$("#queryName").val(),$("#queryGoodsId").val());
                    }, 1000);
                }else{
                    layer.msg(errorMsg,{icon: 5});
                }
            },
            error:function(msg){
                layer.msg(errorMsg,{icon: 5});
            }
        });
    }
    function delGoodsTypeData(ids){
        $.ajax({
            url:'/store/type/delColorType/',
            type:'POST',
            data:{ids:ids},
            success:function (msg) {
                if(msg > 0){
                    layer.msg("删除成功");
                    setTimeout(function(){
                        reloadTableData($("#queryId").val(),$("#queryName").val(),$("#queryGoodsId").val());
                    }, 1000);
                }else{
                    layer.msg("删除失败",{icon: 5});
                }
            },
            error:function(msg){
                layer.msg("删除失败",{icon: 5});
            }
        });
    }
});