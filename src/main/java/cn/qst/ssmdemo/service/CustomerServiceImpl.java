package cn.qst.ssmdemo.service;

import cn.qst.ssmdemo.dao.CustomerMapper;
import cn.qst.ssmdemo.model.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jiangheng
 * @date 2019/9/18 12:44
 * @description
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
    @Resource
    private CustomerMapper customerMapper;
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
}
