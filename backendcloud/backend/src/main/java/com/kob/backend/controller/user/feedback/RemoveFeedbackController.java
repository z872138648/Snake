package com.kob.backend.controller.user.feedback;

import com.kob.backend.service.user.bot.RemoveService;
import com.kob.backend.service.user.feedback.GetFeedbackListService;
import com.kob.backend.service.user.feedback.RemoveFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveFeedbackController {
    @Autowired
    private RemoveFeedbackService removeService;
    @PostMapping("/user/feedback/remove/")
    public Map<String,String> remove(@RequestParam Map<String, String> data){
        return removeService.remove(data);
    }
}
