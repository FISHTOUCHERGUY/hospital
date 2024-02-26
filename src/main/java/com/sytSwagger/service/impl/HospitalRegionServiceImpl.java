package com.sytSwagger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sytSwagger.entity.Hospital;
import com.sytSwagger.entity.HospitalRegion;
import com.sytSwagger.mapper.HospitalMapper;
import com.sytSwagger.mapper.HospitalRegionMapper;
import com.sytSwagger.service.HospitalRegionService;
import com.sytSwagger.service.HospitalService;
import org.springframework.stereotype.Service;

@Service
public class HospitalRegionServiceImpl extends ServiceImpl<HospitalRegionMapper, HospitalRegion> implements HospitalRegionService {
}
