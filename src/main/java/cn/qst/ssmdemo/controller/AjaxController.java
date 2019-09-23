package cn.qst.ssmdemo.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author jiangheng
 * @date 2019/9/21 12:15
 * @description  控制ajax的类
 */
@Controller
public class AjaxController {

    @PostMapping("/register")
    public void register(String phone, HttpServletResponse response){
        System.out.println("客户端传过来的手机号是："+phone);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("17854337592".equals(phone)){
            writer.write("true");
        }else{
            writer.write("false");
        }
    }

    /**
     * 测试jquery的$.ajax()的测试
     * @param phone
     * @param response
     */
    @RequestMapping("/register2")
    public void register2(String phone, HttpServletResponse response){
        System.out.println("客户端传过来的手机号是："+phone);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("17854337592".equals(phone)){
            writer.write("true");
        }else{
            writer.write("false");
        }
    }

    /**
     * 测试ajax的post方法
     * @param phone
     * @param response
     */
    @PostMapping("/register3")
    public void register3(String phone, HttpServletResponse response){
        System.out.println("客户端传过来的手机号是："+phone);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("17854337592".equals(phone)){
            writer.write("true");
        }else{
            writer.write("false");
        }
    }

    /**
     * 测试ajax的get方法
     * @param phone
     * @param response
     */
    @GetMapping("/register4")
    public void register4(String phone, HttpServletResponse response){
        System.out.println("客户端传过来的手机号是："+phone);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("17854337592".equals(phone)){
            writer.write("true");
        }else{
            writer.write("false");
        }
    }

    /**
     * 测试ajax的get方法
     * @param phone
     * @param response
     */
    @RequestMapping("/register5")
    public void register5(String phone, HttpServletResponse response){
        System.out.println("客户端传过来的手机号是："+phone);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("17854337592".equals(phone)){
            writer.write("手机号已经注册，请更换手机号");
        }else{
            writer.write("注册成功");
        }
    }

    /**
     * getJSON方法的测试  如果客户端使用的是getJSON获取数据资源，则返回的结果应该是JSON对象。
     * @param phone
     * @param response
     */
    @GetMapping("/register6")
    public void register6(String phone, HttpServletResponse response){
        System.out.println("客户端传过来的手机号是："+phone);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if("17854337592".equals(phone)){
            writer.print("{\"message\":\"true\"}");
        }else{
            writer.print("{\"message\":\"false\"}");
        }
    }

    /**
     * 处理json对象
     * @param phone
     *
     */
    @GetMapping("/register7")
    @ResponseBody
    public String register7(@RequestBody String phone){
        System.out.println("客户端传过来的手机号是："+phone);
        return phone;
    }


    /**
     * 添加了 @ResponseBody 表名该方法响应的是一个ajax类型的请求，
     * retrun返回的就是对ajax请求的响应内容，而不再是视图的路径
     *
     */
    @ResponseBody
    @RequestMapping("/doAjaxDemo")
    private String doAjaxDemo(){
        // 业务逻辑处理完成后获取的响应信息
        String strMsg = "ajax hello!";
        return strMsg;
    }



}
