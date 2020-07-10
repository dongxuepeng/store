package com.dxp.store.service;

import com.dxp.store.dao.UserDao;
import com.dxp.store.entity.User;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User getUserById(Integer id){
        return userDao.getUserById(id);
    }
    public JSONObject getAllUser(Integer page, Integer limit){
        int stCount = (page-1)*limit;
        int endCount = page*limit;
        List<User> list =  userDao.getAllUsers(stCount,endCount);
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        JSONArray ja = new JSONArray();
        JSONObject joItm =null;
        for(User user : list){
            joItm = new JSONObject();
            joItm.put("id",user.getId());
            joItm.put("name",user.getName());
            joItm.put("sex",user.getSex());
            ja.add(joItm);
        }
        jo.put("count",3);
        jo.put("data",ja);
        return jo;
    }
}
