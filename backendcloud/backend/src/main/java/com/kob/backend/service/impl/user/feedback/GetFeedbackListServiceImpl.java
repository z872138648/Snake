package com.kob.backend.service.impl.user.feedback;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.FeedBackMapper;
import com.kob.backend.pojo.Feedback;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.feedback.GetFeedbackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFeedbackListServiceImpl implements GetFeedbackListService {
    @Autowired
    private FeedBackMapper fbMapper;

    @Override
    public List<Feedback> getList(){
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();
        QueryWrapper<Feedback> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());

        return fbMapper.selectList(queryWrapper);
    }

}
