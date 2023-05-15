package com.kob.backend.controller.user.feedback;

import com.kob.backend.pojo.Feedback;
import com.kob.backend.service.user.feedback.GetFeedbackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class GetFeedbackListController {
    @Autowired
    private GetFeedbackListService getFeedbackListService;

    @GetMapping("/user/feedback/getlist/")
    public List<Feedback> getlist(){
        return getFeedbackListService.getList();
    }
}
