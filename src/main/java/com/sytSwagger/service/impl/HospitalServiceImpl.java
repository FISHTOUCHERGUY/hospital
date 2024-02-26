package com.sytSwagger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sytSwagger.entity.Hospital;
import com.sytSwagger.mapper.HospitalMapper;
import com.sytSwagger.service.HospitalService;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements HospitalService{
}
