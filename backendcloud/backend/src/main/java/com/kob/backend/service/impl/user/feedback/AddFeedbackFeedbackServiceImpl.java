package com.kob.backend.service.impl.user.feedback;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.FeedBackMapper;
import com.kob.backend.pojo.Feedback;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.feedback.AddFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddFeedbackFeedbackServiceImpl implements AddFeedbackService {

    @Autowired
    private FeedBackMapper fbMapper;

    @Override
    public Map<String, String> add(Map<String, String> data){
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        String title = data.get("title");
        String type = data.get("type");
        String feedbackContent = data.get("feedback_content");
        String status = "尚未处理";

        Map<String, String> map = new HashMap<>();

        if (title == null || title.length() == 0) {
            map.put("error_message", "标题不能为空");
            return map;
        }

        if (title.length() > 100) {
            map.put("error_message", "标题长度不能大于100");
            return map;
        }

        if (feedbackContent == null || feedbackContent.length() == 0) {
            map.put("error_message", "反馈内容不能为空");
            return map;
        }
        QueryWrapper<Feedback> queryWrapper = new QueryWrapper<>();

        Date now = new Date();

        Feedback feedback = new Feedback(null, title, type, feedbackContent, user.getId(), "", status,now,now );
        fbMapper.insert(feedback);
        map.put("error_message", "success");

        return map;
    }
}
