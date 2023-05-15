package com.kob.backend.controller.user.feedback;

import com.kob.backend.service.user.feedback.AddFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddFeedbackController {
    @Autowired
    private AddFeedbackService addFeedbackService;
    @PostMapping("/user/feedback/add/")
    public Map<String,String> add(@RequestParam Map<String, String> data){
        return addFeedbackService.add(data);
    }
}
