package com.sytSwagger.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sytSwagger.common.R;
import com.sytSwagger.entity.*;
import com.sytSwagger.service.HospitalLevelService;
import com.sytSwagger.service.HospitalRegionService;
import com.sytSwagger.service.HospitalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    HospitalService hospitalService;
    @Autowired
    HospitalLevelService hospitalLevelService;
    @Autowired
    HospitalRegionService hospitalRegionService;

    //获取医院的分页信息
    @GetMapping("/getHospitalList")
    public R<Page> getHospitals(int page, int pageSize, String name, int levelId, String gTime, int regionId){

        //构造分页构造器
        Page<Hospital> pageInfo = new Page(page,pageSize);

        Page<HospitalDto> dtoPage = new Page<>();

        //构造条件构造器
        LambdaQueryWrapper<Hospital> queryWrapper = new LambdaQueryWrapper<>();

        //添加过滤条件
        queryWrapper.eq(levelId != 0,Hospital::getLevelId,levelId);
        queryWrapper.eq(regionId != 0,Hospital::getRegionId,regionId);
        queryWrapper.eq(gTime != null,Hospital::getGTime,gTime);
        queryWrapper.like(name != null,Hospital::getName,name);

        //添加排序条件
        queryWrapper.orderByAsc(Hospital::getId);

        //执行查询
        hospitalService.page(pageInfo,queryWrapper);

        BeanUtils.copyProperties(pageInfo,dtoPage,"records");

        List<Hospital> hospitalList = pageInfo.getRecords();
        List<HospitalDto> dtoList = hospitalList.stream().map((item)->{
            HospitalDto dto = new HospitalDto();

            BeanUtils.copyProperties(item,dto);

            HospitalLevel hospitalLevel = hospitalLevelService.getById(item.getLevelId());

            //设置dto中level
            dto.setLevel(hospitalLevel.getLevel());

            return dto;
        }).collect(Collectors.toList());

        dtoPage.setRecords(dtoList);

        return R.success(dtoPage);
    }

    @GetMapping("/getDetail/{id}")
    public R<Hospital> getDetail(@PathVariable Long id){

        Hospital hospital = hospitalService.getById(id);
        HospitalDto hospitalDto = new HospitalDto();



        if(hospital != null){

            BeanUtils.copyProperties(hospital,hospitalDto);
            HospitalLevel hospitalLevel = hospitalLevelService.getById(hospital.getLevelId());
            hospitalDto.setLevel(hospitalLevel.getLevel());

            return R.success(hospitalDto);
        }
        return R.error("不存在");
    }

    @GetMapping("/getLevels")
    public R<List<HospitalLevel>> getLevels(){

        return R.success(hospitalLevelService.list());

    }

    @GetMapping("/getRegions")
    public R<List<HospitalRegion>> getRegions(){

        return R.success(hospitalRegionService.list());
    }

    @GetMapping("/getSearchList")
    public R<List<SearchList>> getSearchList(){

        List<SearchList> list = new ArrayList<>();

        List<Hospital> hospitals = hospitalService.list();
        for (Hospital hospital : hospitals) {
            SearchList searchList = new SearchList();
            searchList.setId(hospital.getId());
            searchList.setValue(hospital.getName());
            list.add(searchList);
        }

        return R.success(list);
    }
}
