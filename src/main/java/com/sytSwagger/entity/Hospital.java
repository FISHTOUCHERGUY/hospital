package com.sytSwagger.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Hospital {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String name;

    private Long levelId;

    private String gTime;

    private String regionId;

    private String logo;

    private String appointmentCircle;

    private String registerTime;

    private String stopTime;

}
