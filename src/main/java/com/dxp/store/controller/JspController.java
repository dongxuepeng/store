package com.dxp.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "jsp")
public class JspController {
    @RequestMapping(value = "portal")
    public String getPortal(){
        return "jsp/portal";
    }
    @RequestMapping(value = "import")
    public String getImport(String typeId){
        String jspPath = "";
        if("lbwh_sp".equals(typeId)){
            jspPath = "jsp/typeGoodsPage";
        }else if("lbwh_ys".equals(typeId)){
            jspPath = "jsp/typeColorPage";
        }else{
            jspPath = "jsp/importGoods";
        }
        return jspPath;
    }
}
