package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.Feedback;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedBackMapper extends BaseMapper<Feedback> {
}
