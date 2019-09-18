package cn.qst.ssmdemo.controller;

import cn.qst.ssmdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangheng
 * @date 2019/9/18 10:43
 * @description 控制web-Info下面的文件的加载
 */
@Controller
public class ForwardCommons {
    /**
     * 执行服务端转发跳转页面的功能
     * @param page  转发的目标路径，{注意;不包含视图解析器的前后缀}
     * @return  返回的是目标页面
     */
    @RequestMapping("/forward" )
    public String getForward(String page){
        return page;
    }


}
