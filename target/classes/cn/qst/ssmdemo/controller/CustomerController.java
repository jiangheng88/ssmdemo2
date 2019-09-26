package cn.qst.ssmdemo.controller;

import cn.qst.ssmdemo.model.Customer;

import cn.qst.ssmdemo.model.User;
import cn.qst.ssmdemo.service.CustomerService;

import cn.qst.ssmdemo.utils.MyUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
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
     * 添加用户的方法，含有上传文件部分,这个方法是吧文件流当做实体类的属性，直接从实体类中获取文件流，
     * 但是前段页面中的name属性就的和属性名一致
     *
     * @param customer
     * @return
     */
    @RequestMapping("/insertCustomer")
    public String doAddUser(Customer customer) {
        System.out.println("接收到的添加用户是" + customer);
        //文件保存的路径
        String path = "G:\\temps";
        //定义保存文件的位置的数据库列名
        String sqlPath = null;
        //定义上传文件的原始名
        String fileName = null;
        if (customer != null) {
            //得到上传的文件
            MultipartFile multipartFile = customer.getMultipartFile();
            if (!multipartFile.isEmpty()) {//如果文件不为空
                //文件的名字
                fileName = multipartFile.getOriginalFilename();
                //创建文件
                File filePath = new File(path, fileName);
                if (!filePath.getParentFile().exists()) {//如果父文件夹不存在
                    //注意mkdirs()和mkdir()的区别，mkdirs()他可以直接创建文件夹，不管父文件夹是否存在，
                    //mkdir()创建文件夹时，父文件夹一定的存在
                    filePath.getParentFile().mkdirs();
                }
                //文件在硬盘中的位置
                sqlPath = path + File.separator + fileName;
                System.out.println(sqlPath);
                try {
                    //将文件上传到指定位置
                    multipartFile.transferTo(new File(sqlPath));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            customer.setImgPath(sqlPath);
            int i = customerService.insertSelective(customer);
            if (i > 0) {
                return "customermanage/selectCustomer";
            }
        }
        return "customermanage/addCustomer";
    }


    @RequestMapping("/doselectCustomer")
    public String doSelectUser(Model model, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum == 0)
            pageNum = 1;
        if (pageSize == null || pageSize == 0)
            pageSize = 6;
        PageInfo<Customer> customersbyPage = customerService.selectByCustomer(pageNum, pageSize);
        model.addAttribute("customersbyPage", customersbyPage);
        return "customermanage/selectCustomer";
    }

    /**
     * 上传文件到本地磁盘，数据库中只保存文件的访问路径，这个方法更安全
     *
     * @param customer      客戶端要添加的用戶
     * @param multipartFile //客户端传过来的文件流
     * @return
     */
    @RequestMapping("/doAddCustomer")
    public String insertCustomer(Customer customer, @RequestParam("file_imgPath") MultipartFile multipartFile) {
        //调用封装好的上传文件的静态方法
        MyUtils.singleFileUpload(multipartFile, customer, "uploadfiles/userimgfiles/", "userimg");
        // 调用Service层进行用户信息数据保存和修改操作
        System.out.println(customer.getImgPath());
        int i = customerService.insertSelective(customer);
        // 根据操作结果进行视图转发处理
        return "redirect:/doselectCustomer";

    }

}
