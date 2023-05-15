package com.kob.backend.service.impl.user.feedback;

import com.kob.backend.mapper.FeedBackMapper;
import com.kob.backend.pojo.Feedback;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.feedback.RemoveFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveFeedbackServiceImpl implements RemoveFeedbackService {
    @Autowired
    private FeedBackMapper fdMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data){
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int feedback_id = Integer.parseInt(data.get("feedback_id"));
        Feedback feedback = fdMapper.selectById(feedback_id);

        Map<String, String> map = new HashMap<>();

        if(feedback == null) {
            map.put("error_message","反馈不存在或者已被删除");
        }

        if(!feedback.getUserId().equals(user.getId())){
            map.put("error_message","没有权限删除该反馈");
            return map;
        }

        fdMapper.deleteById(feedback_id);
        map.put("error_message", "success");
        return map;
    }
}
