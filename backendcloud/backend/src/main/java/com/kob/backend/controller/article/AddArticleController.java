package com.kob.backend.controller.article;

import com.kob.backend.service.article.AddArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddArticleController {
    @Autowired
    private AddArticleService addArticleService;
    @PostMapping("/article/add/")
    public Map<String, String> add(@RequestParam Map<String, String> data){return addArticleService.add(data);};
}
