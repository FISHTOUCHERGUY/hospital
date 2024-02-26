package com.sytSwagger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sytSwagger.entity.Hospital;
import com.sytSwagger.entity.User;
import com.sytSwagger.mapper.HospitalMapper;
import com.sytSwagger.mapper.UserMapper;
import com.sytSwagger.service.HospitalService;
import com.sytSwagger.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
