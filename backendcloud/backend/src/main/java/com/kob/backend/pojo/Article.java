package com.kob.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String contentMd;
    private String contentHtml;
    private int likeCount;
    private int commentCount;
    private int readCount;
    private int topFlag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createtime;
    private int userId;
}
