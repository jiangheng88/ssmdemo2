package cn.qst.ssmdemo.service;

import cn.qst.ssmdemo.model.Customer;
import cn.qst.ssmdemo.model.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    /*查询所用的用户*/

    public List<Customer> selectAllCustomer();

    public PageInfo<Customer> selectByCustomer( Integer pageNum, Integer pageSize);

    /*模糊查询*/

    public List<Customer> listCustomerByInfo(Customer customer);

    /*逻辑删除*/
    public int deleteCustomerByLogic(Integer customerId);
}
