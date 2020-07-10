layui.use('element', function(){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

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
function unflodEle(ele,elem){
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
    }
    if(id == 'lbwh' || id == 'syfx'){
        return ;
    }
        var tabArry = $($(".layui-tab-title")[0]).children();
        for(var y=0;y<tabArry.length;y++){
            var itemId = $(tabArry[y]).attr("lay-id");
            if(id == itemId){
                ele.tabChange('tabs', id);
                return;
            }
        }
        ele.tabAdd('tabs', {
            title: elem.text() //用于演示
            ,content: "<iframe name='myIframe' id='myIframe' src='/store/jsp/import?typeId="+id+"'" +
            " frameborder='0' align='left' width='100%' class='pull-left' height='500px' " +
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