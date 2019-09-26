package cn.qst.ssmdemo.controller;

import cn.qst.ssmdemo.model.Customer;
import cn.qst.ssmdemo.model.User;
import cn.qst.ssmdemo.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sun.misc.Request;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author jiangheng
 * @date 2019/9/22 16:12
 * @description json控制的类，主要是测试json的功能
 */
@Controller
public class JsonController {
    @Resource(name = "customerService")
    private CustomerService customerService;

    /**
     * 输出后发现有乱码问题，可以在注解中设置，也可以在springmvc的配置文件中配置
     *
     * @return
     */
    /*在注解中解决乱码*/
    @RequestMapping(value = "/json", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getJson() {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setUsername("姜恒");
        user.setUserpass("密码");
        user.setId(1);
        String string = null;
        try {
            string = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return string;
    }

    /**
     * 在配置文件中解决乱码问题
     *
     * @return
     */
    @RequestMapping(value = "/json2")
    @ResponseBody
    public String getJson2() {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setUsername("姜恒");
        user.setUserpass("密码");
        user.setId(1);
        String string = null;
        try {
            string = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return string;
    }

    @RequestMapping(value = "/json3")
    @ResponseBody
    public Date getJson3() {
        Date date = new Date();
        return date;
    }

    @RequestMapping(value = "/listquerybylike")
    @ResponseBody
    public List<Customer> listCustomerByinfo(Customer customer) {
        System.out.println(customer);
        List<Customer> list = customerService.listCustomerByInfo(customer);
        System.out.println(list);
        return list;
    }
    @ResponseBody
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomerById(Customer customer) {
        int i = customerService.updateByPrimaryKeySelective(customer);
        if(i>0){
            return "修改成功";
        }else{
            return "修改失败，请重新修改";
        }

    }

    @ResponseBody
    @RequestMapping("/deleteCustomerbyAjax")
    public int deleteCustomer(int customerId) {
        System.out.println("执行到了后台");
        int i = customerService.deleteCustomerByLogic(customerId);
        return i;
    }
}
