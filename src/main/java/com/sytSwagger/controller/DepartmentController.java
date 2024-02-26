package com.sytSwagger.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sytSwagger.common.R;
import com.sytSwagger.entity.Department;
import com.sytSwagger.entity.Outpatient;
import com.sytSwagger.service.DepartmentService;
import com.sytSwagger.service.HospitalService;
import com.sytSwagger.service.OutpatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    HospitalService hospitalService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    OutpatientService outpatientService;

    @GetMapping("/getDepartments/{hospitalId}")
    public R<List<Department>> getDepartments(@PathVariable Long hospitalId){

        LambdaQueryWrapper<Department> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Department::getHospitalId,hospitalId);
        List<Department> departmentList = departmentService.list(queryWrapper);

        return R.success(departmentList);

    }

    @GetMapping("/getOutpatients/{departmentId}")
    public R<List<Outpatient>> getOutpatients(@PathVariable Long departmentId){
        List<Outpatient> outpatientList = null;
        if(departmentId != 0){
            LambdaQueryWrapper<Outpatient> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Outpatient::getDepartmentId,departmentId);
            outpatientList = outpatientService.list(queryWrapper);
        }

        return R.success(outpatientList);

    }
}
