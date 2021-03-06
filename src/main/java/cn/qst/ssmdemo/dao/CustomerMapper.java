package cn.qst.ssmdemo.dao;

import cn.qst.ssmdemo.model.Customer;
import org.apache.ibatis.annotations.Param;

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

    /*模糊查询*/

    public List<Customer> listCustomerByInfo(Customer customer);

    /*逻辑删除*/
    public int deleteCustomerByLogic(@Param("customerId") Integer customerId);


}