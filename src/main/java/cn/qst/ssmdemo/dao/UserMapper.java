package cn.qst.ssmdemo.dao;

import cn.qst.ssmdemo.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /*登录的方法*/
    public User dologin(User user);
}