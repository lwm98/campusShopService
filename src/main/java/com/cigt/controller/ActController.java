package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.service.ActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/api")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ActController {
    @Autowired
    private ActService actService;

    @GetMapping("/getActsList")
    public R getActsList(int store_id){
        return actService.getActsList(store_id);
    }
}
