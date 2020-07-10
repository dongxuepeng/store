package com.dxp.store.controller;

import com.dxp.store.service.GoodsTypeService;
import com.dxp.store.service.UserService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "type")
public class TypeController {
    @Autowired
    GoodsTypeService goodsTypeService;
    @RequestMapping(value = "goods")
    public JSONObject getGoodsType(@Param("id") Integer id, @Param("name") String name, Integer page, Integer limit){
        return goodsTypeService.getAllGoodsType(id,name,page,limit);
    }
    @RequestMapping(value = "checkGoodsTypeName")
    public Integer checkGoodsTypeName(@Param("id") String id, @Param("name") String name){
        if("自动生成".equals(id)){
            return goodsTypeService.getGoodsTypeByName(null,name);
        }else{
            return goodsTypeService.getGoodsTypeByName(Integer.parseInt(id),name);
        }

    }
    @RequestMapping(value = "updateGoodsType")
    public JSONObject updateGoodsType(@Param("id") Integer id, @Param("name") String name){
        return goodsTypeService.updateGoodsType(id,name);
    }
    @RequestMapping(value = "addGoodsType")
    public JSONObject addGoodsType(@Param("name") String name){
        return goodsTypeService.addGoodsType(name);
    }

    @RequestMapping(value = "delGoodsType")
    public Integer delGoodsType(@Param("ids") String ids){
        return goodsTypeService.delGoodsType(ids);
    }
}
