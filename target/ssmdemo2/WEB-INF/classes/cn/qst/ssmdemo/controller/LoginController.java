package cn.qst.ssmdemo.controller;

;
import cn.qst.ssmdemo.model.User;
import cn.qst.ssmdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2019/9/11 17:09
 * @description
 */
@Controller
public class LoginController {
    @Resource(name = "userService")
    private UserService userService;
    @RequestMapping("/mian")
    public String getMain(){
        return "main";
    }

    @RequestMapping("/login")
    public String doLogin(User user){

        User user1 = userService.dologin(user);
        if(user1!=null){
            System.out.println("登录成功");
            return "main";
        }else{
            return "";
        }
    }
}
