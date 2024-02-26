package com.sytSwagger.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sytSwagger.entity.Hospital;
import com.sytSwagger.entity.Outpatient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OutpatientMapper extends BaseMapper<Outpatient> {
}
