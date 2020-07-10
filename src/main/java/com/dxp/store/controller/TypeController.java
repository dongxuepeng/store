package com.dxp.store.controller;

import com.dxp.store.service.ColorTypeService;
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

    @Autowired
    ColorTypeService colorTypeService;
    @RequestMapping(value = "color")
    public JSONObject getColorType(@Param("id") Integer id, @Param("name") String name, @Param("goodsType") Integer goodsType,Integer page, Integer limit){
        return colorTypeService.getAllColorType(id,name,goodsType,page,limit);
    }
    @RequestMapping(value = "checkColorName")
    public Integer checkColorName(@Param("id") String id, @Param("name") String name,@Param("goods") Integer goods){
        if("自动生成".equals(id)){
            return colorTypeService.getColorTypeByName(null,name,goods);
        }else{
            return colorTypeService.getColorTypeByName(Integer.parseInt(id),name,goods);
        }

    }
    @RequestMapping(value = "updateColorType")
    public Integer updateColorType(@Param("id") Integer id, @Param("name") String name,@Param("goods") Integer goods){
        return colorTypeService.updateColorType(id,name,goods);
    }
    @RequestMapping(value = "addColorType")
    public Integer addColorType(@Param("name") String name,@Param("goods") Integer goods){

        return colorTypeService.addColorType(name,goods);
    }

    @RequestMapping(value = "delColorType")
    public Integer delColorType(@Param("ids") String ids){
        return colorTypeService.delColorType(ids);
    }
}
