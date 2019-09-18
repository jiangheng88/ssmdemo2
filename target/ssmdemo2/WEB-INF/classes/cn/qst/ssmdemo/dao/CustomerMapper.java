package cn.qst.ssmdemo.dao;

import cn.qst.ssmdemo.model.Customer;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    /*查询所用的用户*/

    public List<Customer> selectAllCustomer();


}