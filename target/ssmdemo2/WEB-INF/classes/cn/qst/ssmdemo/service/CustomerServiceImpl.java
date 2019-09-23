package cn.qst.ssmdemo.service;

import cn.qst.ssmdemo.dao.CustomerMapper;
import cn.qst.ssmdemo.model.Customer;
import cn.qst.ssmdemo.model.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiangheng
 * @date 2019/9/18 12:44
 * @description
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
    @Resource
    private CustomerMapper customerMapper;

    /*模糊查询的方法*/
    @Override
    public List<Customer> listCustomerByInfo(Customer customer) {
        return customerMapper.listCustomerByInfo(customer);
    }

    @Override
    public int deleteByPrimaryKey(Integer customerId) {
        return customerMapper.deleteByPrimaryKey(customerId);
    }

    @Override
    public int insert(Customer record) {
        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(Customer record) {
        return customerMapper.insertSelective(record);
    }

    @Override
    public Customer selectByPrimaryKey(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {

        return customerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Customer> selectAllCustomer() {

        return customerMapper.selectAllCustomer();
    }

    public PageInfo<Customer> selectByCustomer( Integer pageNum, Integer pageSize) {
        Page<Customer> page = PageHelper.startPage(pageNum, pageSize);
        // 获得查询的信息
        List<Customer> customers = customerMapper.selectAllCustomer();
        PageInfo<Customer> pInfo = new PageInfo<Customer>(customers);
        return pInfo;
    }
}
