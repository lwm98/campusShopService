package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @PostMapping("/clicksAddInfo")
    @ResponseBody
    public R clicksAdd(int id) { return  areaService.clicksAdd(id); }

}
