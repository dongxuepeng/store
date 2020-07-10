package com.dxp.store.service;

import com.dxp.store.dao.ColorTypeDao;
import com.dxp.store.entity.ColorType;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ColorTypeService {
    @Autowired
    ColorTypeDao colorTypeDao;

    public JSONObject getAllColorType(Integer id, String name, Integer goodsType, Integer page, Integer limit) {
        Integer stCount = null == page ? null :(page-1)*limit;
        Integer endCount = null == page ? null : page*limit;
        List<Map> list =  colorTypeDao.getAllColorType(id,name,goodsType,stCount,endCount);
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        JSONArray ja = new JSONArray();
        JSONObject joItm =null;
        for(Map colorType : list){
            joItm = new JSONObject(colorType);
            ja.add(joItm);
        }
        jo.put("count",colorTypeDao.getColorTypeCount(id,name,goodsType));
        jo.put("data",ja);
        return jo;
    }

    public Integer getColorTypeByName(Integer id, String name, Integer goods) {
        return colorTypeDao.getColorTypeByName(id,name,goods);
    }

    public Integer updateColorType(Integer id, String name, Integer goods) {
        return colorTypeDao.updateColorType(id,name,goods);
    }

    public Integer addColorType(String name, Integer goods) {
        return colorTypeDao.addColorType(name,goods);
    }

    public Integer delColorType(String ids) {
        List<Integer> list = new ArrayList<Integer>();
        for(String id : ids.split(",")){
            list.add(Integer.parseInt(id));
        }
        return colorTypeDao.delColorType(list);
    }
}
