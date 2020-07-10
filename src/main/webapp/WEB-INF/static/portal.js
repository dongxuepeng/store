$(function(){
    //动态加载商品名称
    reloadGooldsType("first","","");
});
var element;
layui.use('element', function(){
    element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

    //监听导航点击
    element.on('nav(navs)', function(elem){
        unflodEle(element,elem);
    });
    element.on('tab(tabs)', function(data){
        var currTabId = this.getAttribute('lay-id');
        //动态改变左侧菜单
        changeNavs(currTabId);
    });
});
var ifreamHeight = 0;
function unflodEle(ele,elem){
    var contentTd = $("#countTd");
    ifreamHeight = parseInt(contentTd.css("height")) - parseInt($(contentTd.children()[0]).css("height"));
    var id = elem.attr("data-id");
    var idexId = id.indexOf("_");
    if(idexId < 0) {
        var liEles = $(".layui-nav-item");
        for (var i = 0; i < liEles.length; i++) {
            var itemId = $(liEles[i]).attr("id");
            if (id != itemId) {
                $(liEles[i]).removeClass("layui-nav-itemed");
            }
        }
        var attrId = $($($($("#"+id).children()[1]).children()[0]).children()[0]).attr("data-id");
        id = attrId;
    }
    /*if(id == 'lbwh' || id == 'syfx'){
        return ;
    }*/
    var tabArry = $($(".layui-tab-title")[0]).children();
    for(var y=0;y<tabArry.length;y++){
        var itemId = $(tabArry[y]).attr("lay-id");
        if(id == itemId){
            ele.tabChange('tabs', id);
            return;
        }
    }
    ele.tabAdd('tabs', {
        title: $("a[data-id = '"+id+"']").text()/*elem.text()*/
        ,content: "<iframe name='myIframe' id='myIframe' src='/store/jsp/import?typeId="+id+"'" +
        " frameborder='0' align='left' width='100%' class='pull-left' height='"+ifreamHeight+"' " +
        "scrolling='no'></iframe>"
        ,id: id
    })
    ele.tabChange('tabs', id);
}

function changeNavs(cId){
    var id= "";
    var indexId = cId.indexOf("_");
    if(indexId >= 0){
        id = cId.substring(0,indexId);
    }else{
        id = cId;
    }
    var liEles = $(".layui-nav-item");
    for(var i=0;i<liEles.length;i++){
        var itemId = $(liEles[i]).attr("id");
        if(id != itemId){
            $(liEles[i]).removeClass("layui-nav-itemed");
        }else{
            $(liEles[i]).addClass("layui-nav-itemed");
        }
    }
    var ddEles = $("dd");
    for(var y=0;y<ddEles.length;y++){
        var itemId = $(ddEles[y]).children().attr("data-id");
        if(cId != itemId){
            $(ddEles[y]).removeClass("layui-this");
        }else{
            $(ddEles[y]).addClass("layui-this");
        }
    }
}

function reloadGooldsType(type,thisId,newTitle){
    $.ajax({
        url:'/store/type/goods/',
        type:'POST',
        data:{aa:"aa"},
        success:function (msg) {
            var spgl_dl = $("#spgl_dl");
            spgl_dl.children().remove();
            var data = msg.data;
            for(var i=0;i<data.length;i++){
                var id = data[i].id;
                var name = data[i].name;
                var dataId = 'spgl_'+id;
                spgl_dl.append("<dd><a href='javascript:;' data-id='"+dataId+"'>"+name+"</a></dd>");
            }

        },
        error:function(data){
        }
    });
    setTimeout(function(){
        if(type == 'first'){
            var elem = $($($(".layui-nav-item")[0]).children()[0]);
            unflodEle(element,elem);
        }else{
            element.init();
        }

        //改变tab标签
        if(type == 'edit'){
            if(checkHasTab(thisId)){
                var thisLi = $("li[lay-id='spgl_"+thisId+"']");
                var oldHtml = $(thisLi.children()[0]);
                thisLi.text(newTitle);
                thisLi.append(oldHtml);
                oldHtml.on("click",function(){
                    element.tabDelete("tabs", "spgl_"+thisId);
                });
            }
        }else if(type == 'del'){
            var idsArr = (""+thisId).split(",");
            for(var i=0;i<idsArr.length;i++){
                if(checkHasTab(idsArr[i])){
                    element.tabDelete("tabs", "spgl_"+idsArr[i]);
                }
            }
        }
    }, 1000);


}
function checkHasTab(id){
    var thisId = "";
    if((""+id).indexOf("_") > 0){
        thisId = id;
    }else{
        thisId = "spgl_"+id;
    }
    var tabArry = $($(".layui-tab-title")[0]).children();
    for(var y=0;y<tabArry.length;y++){
        var itemId = $(tabArry[y]).attr("lay-id");
        if(thisId == itemId){
            return true;
        }
    }
    return false;
}