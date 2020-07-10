package com.dxp.store.controller;

import com.dxp.store.entity.User;
import com.dxp.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "import")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "portal")
    public ModelAndView portal(){
        ModelAndView view = new ModelAndView();
        view.setViewName("portal");
        return view;
    }
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
}
