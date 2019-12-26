package com.cigt.controller;


import com.cigt.base.R;
import com.cigt.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("/getAllStoreInfo")
    @ResponseBody
    public R getAllStore(int id){ return  storeService.getAllStore(id); }
}
