package com.sytSwagger.entity;

import lombok.Data;

@Data
public class HospitalDto extends Hospital{

    private String level;

    private String region;
}
