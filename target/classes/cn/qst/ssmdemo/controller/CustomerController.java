package cn.qst.ssmdemo.controller;

import cn.qst.ssmdemo.model.Customer;
import cn.qst.ssmdemo.model.User;
import cn.qst.ssmdemo.service.CustomerService;
import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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
     *
     * @param customer
     * @return
     */
    @RequestMapping("/doAddCustomer")
    public String doAddUser(Customer customer) {
        int i = customerService.insertSelective(customer);
        if (i > 0) {
            return "customermanage/selectCustomer";
        } else {
            return "customermanage/addCustomer";
        }

    }
    @RequestMapping("/doselectCustomer")
    public String doSelectUser(Model mdoel) {
       List<Customer> customers =  customerService.selectAllCustomer();
        mdoel.addAttribute("customer",customers);
        System.out.println("查询到的所用用户是："+customers);
        return "customermanage/selectCustomer";
    }

}
