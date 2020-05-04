package com.cigt.controller;


import com.cigt.base.R;
import com.cigt.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "*",maxAge = 3600)
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/getAllStoreInfo")
    @ResponseBody
    public R getAllStore(){ return  storeService.getAllStore(); }

    @GetMapping("/getStoreByArea")
    @ResponseBody
    public R getStoreByArea(int id){
        return storeService.getStoreByArea(id);
    }

    @GetMapping("/getStoreByid")
    @ResponseBody
    public R getStoreByid(int id){
        return storeService.getStoreByid(id);
    }

    @GetMapping("/getAllStoreList")
    @ResponseBody
    public  R getAllStoreList(){
        return storeService.getAllStoreList();
    }

    @GetMapping("/getAllzlStore")
    @ResponseBody
    public  R getAllzlStore(){
        return storeService.getAllzlStore();
    }

    @GetMapping("/getAllwzlStore")
    @ResponseBody
    public  R getAllwzlStore(){
        return storeService.getAllwzlStore();
    }
}
