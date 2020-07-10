package com.dxp.store.service;

import com.dxp.store.dao.GoodsTypeDao;
import com.dxp.store.entity.GoodsType;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsTypeService {
    @Autowired
    GoodsTypeDao goodsTypeDao;
    public JSONObject getAllGoodsType(Integer id, String name,Integer page, Integer limit){
        Integer stCount = null == page ? null :(page-1)*limit;
        Integer endCount = null == page ? null : page*limit;
        List<GoodsType> list =  goodsTypeDao.getAllGoodsType(id,name,stCount,endCount);
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        JSONArray ja = new JSONArray();
        JSONObject joItm =null;
        for(GoodsType goodsType : list){
            joItm = new JSONObject();
            joItm.put("id",goodsType.getTypeId());
            joItm.put("name",goodsType.getTypeName());
            ja.add(joItm);
        }
        jo.put("count",goodsTypeDao.getGoodsTypeCount(id,name));
        jo.put("data",ja);
        return jo;
    }

    public Integer updateGoodsType(Integer id, String name) {
        return goodsTypeDao.updateGoodsType(id,name);
    }

    public Integer addGoodsType(String name) {
        return goodsTypeDao.addGoodsType(name);
    }

    public Integer getGoodsTypeByName(Integer id, String name) {
        return goodsTypeDao.getGoodsTypeByName(id,name);
    }

    public Integer delGoodsType(String ids) {
        List<Integer> list = new ArrayList<Integer>();
        for(String id : ids.split(",")){
            list.add(Integer.parseInt(id));
        }
        return goodsTypeDao.delGoodsType(list);
    }
}
