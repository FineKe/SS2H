package com.litesky.service;

import com.litesky.model.User;

import java.util.List;

/**
 *
 * @author finefine.com
 * @date 2017/11/15
 */
public interface UserService {

    /**
     * 获取指定id的用户
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     * 增加用户
     * @param user
     */
    public void save(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void update(User user);

    /**
     * 指定id删除用户
     * @param id
     */
    public void delete(int id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 根据用户名密码查找用户
     * @param name
     * @param pwd
     * @return
     */
    public User findUserByNameAndPwd(String name, String pwd);
}
