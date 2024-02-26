package com.sytSwagger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sytSwagger.entity.Hospital;
import com.sytSwagger.entity.Outpatient;
import com.sytSwagger.mapper.HospitalMapper;
import com.sytSwagger.mapper.OutpatientMapper;
import com.sytSwagger.service.HospitalService;
import com.sytSwagger.service.OutpatientService;
import org.springframework.stereotype.Service;

@Service
public class OutpatientServiceImpl extends ServiceImpl<OutpatientMapper, Outpatient> implements OutpatientService {
}
