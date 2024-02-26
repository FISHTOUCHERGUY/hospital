package com.sytSwagger.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sytSwagger.common.R;
import com.sytSwagger.entity.User;
import com.sytSwagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {


    @Autowired
    UserService userService;

    //用户注册
    @PostMapping("/register")
    public R<Object> register(@RequestBody User user){

        //查询该用户是否已存在
        if(checkUser(user.getPhone())){
            return R.error("用户已存在，请直接登录！");
        }


        userService.save(user);
        return R.success(user);
    }

    //用户登录
    @PostMapping("/login")
    public R<Object> login(@RequestBody User user){

        //查询用户是否已存在
        if (checkUser(user.getPhone())){
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,user.getPhone()).eq(User::getPassword,user.getPassword());
            User one = userService.getOne(queryWrapper);
            if(one != null){
                return R.success(one);
            }
            return R.error("密码错误！");
        }

        return R.error("该用户不存在！");

    }


    //封装用户检验
    private Boolean checkUser(String phone){

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,phone);
        User one = userService.getOne(queryWrapper);

        return one!=null;
    }
}
