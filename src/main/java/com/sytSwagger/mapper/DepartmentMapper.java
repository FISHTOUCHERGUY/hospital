package com.sytSwagger.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sytSwagger.entity.Department;
import com.sytSwagger.entity.Hospital;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
}
