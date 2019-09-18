package cn.qst.ssmdemo.controller;

import cn.qst.ssmdemo.model.Customer;
import cn.qst.ssmdemo.model.User;
import cn.qst.ssmdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author jiangheng
 * @date 2019/9/18 12:48
 * @description
 */
@Controller
public class CustomerController {
    @Resource(name = "customerService")
    private CustomerService customerService;
    @GetMapping("/updateCustomer")
    public String getUpdateUser() {
        return "customermanage/updateCustomer";
    }

    /**
     * 添加用户的方法
     * @param customer
     * @return
     */
    @RequestMapping("/doAddCustomer")
    public String doAddUser(Customer customer){
        int i = customerService.insertSelective(customer);
        if(i>0){
            return "customermanage/selectCustomer";
        }else {
            return "customermanage/addCustomer";
        }

    }
    public String doSelectUser(){
        return "";
    }

}
