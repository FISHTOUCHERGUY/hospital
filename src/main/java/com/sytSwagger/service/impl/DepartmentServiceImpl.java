package com.sytSwagger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sytSwagger.entity.Department;
import com.sytSwagger.entity.Hospital;
import com.sytSwagger.mapper.DepartmentMapper;
import com.sytSwagger.mapper.HospitalMapper;
import com.sytSwagger.service.DepartmentService;
import com.sytSwagger.service.HospitalService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
