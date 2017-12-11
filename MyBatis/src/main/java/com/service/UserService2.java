package com.service;

import com.mappers.UserMapper;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: ZhangQingrong
 * @Date : 2017/12/5 17:32
 */
@Service
public class UserService2 {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 发生异常时，事务回滚，两条语句均未提交
     * */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testREQUIRED1(boolean isThrowException) throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("xiaoqin");
        user.setSalary(10000.00);
        userMapper.save(user);
        user.setName("qingrong");
        user.setSalary(30000.00);
        userMapper.save(user);
        if (isThrowException) {
            throw new Exception("test");
        }
    }

    /**
     * 发生异常时，事务回滚，两条语句均未提交
     * */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testREQUIRED2(boolean isThrowException) throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("xiaoqin");
        user.setSalary(10000.00);
        userMapper.save(user);
        user.setName("qingrong");
        user.setSalary(30000.00);
        userService.save(user);
        if (isThrowException) {
            throw new Exception("test");
        }
    }

    /**
     * 发生异常时，事务回滚，两条语句均未提交
     * */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void testREQUIRES_NEW1(boolean isThrowException) throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("xiaoqin");
        user.setSalary(10000.00);
        userMapper.save(user);
        user.setName("qingrong");
        user.setSalary(30000.00);
        userMapper.save(user);
        if (isThrowException) {
            throw new Exception("test");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testREQUIRES_NEW2(boolean isThrowException) throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("xiaoqin");
        user.setSalary(10000.00);
        userMapper.save(user);
        user.setName("qingrong");
        user.setSalary(30000.00);
        userService.save(user);
        if (isThrowException) {
            throw new Exception("test");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testREQUIRES_NEW3(boolean isThrowException) {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("xiaoqin");
        user.setSalary(10000.00);
        userMapper.save(user);
        user.setName("qingrong");
        user.setSalary(30000.00);
        try {
            userService.save2(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
