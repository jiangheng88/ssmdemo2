package cn.qst.ssmdemo.controller;

import cn.qst.ssmdemo.model.User;
import cn.qst.ssmdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author jiangheng
 * @date 2019/9/17 22:13
 * @description 控制用户的增删改查的类
 */
@Controller
public class UserController {
@Resource(name = "userService")
private UserService userService;
    @GetMapping("/updateUser")
    public String getUpdateUser() {
        return "userInfo/updateUser";
    }

    /**
     * 添加用户的方法
     * @param user
     * @return
     */
    @RequestMapping("/doAddUser")
    public String doAddUser(User user){
        userService.insertSelective(user);
        return "userInfo/selectUser";
    }

    public String doSelectUser(){
    return "";
    }


}
