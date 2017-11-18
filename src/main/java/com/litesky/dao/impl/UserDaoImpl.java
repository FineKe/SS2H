package com.litesky.dao.impl;

import com.litesky.dao.UserDao;
import com.litesky.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by finefine.com on 2017/11/15.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public User findUserById(int id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        User user=session.load(User.class,id);
        transaction.commit();
        return user;
    }

    @Override
    public void save(User user) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        User user=new User();
        user.setId(id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        List<User> list=session.createQuery("from com.litesky.model.User").list();
        transaction.commit();
        return list;
    }

    @Override
    public User findUserByNameAndPwd(String name, String pwd) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        SQLQuery sqlQuery=session.createSQLQuery("SELECT * FROM user WHERE username=\""+name+"\" and password=\""+pwd+"\"");
        sqlQuery.addEntity(User.class);
        List<User> list= sqlQuery.list();
        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
    }
}
