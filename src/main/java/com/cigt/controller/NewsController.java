package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.service.NewsService;
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
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * 获取资讯详情页接口
     * @param id
     * @return
     */
    @GetMapping("/getNews")
    public R getNews(int id){
        return newsService.getNews(id);
    }

    /**
     * 根据商铺id查询该商铺下的所有新闻列表
     * @param store_id
     * @return
     */
    @GetMapping("/getNewsList")
    public R getNewsList(int store_id){
        return newsService.getNewsList(store_id);
    }

    /**
     * 获取所有新闻
     * @return
     */
    @GetMapping("/getAllNewsList")
    public R getAllNewsList(){
        return newsService.getAllNewsList();
    }
}
