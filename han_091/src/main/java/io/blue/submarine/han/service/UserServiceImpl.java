package io.blue.submarine.han.service;

import io.blue.submarine.han.aop.DataSource;
import io.blue.submarine.han.aop.RouterDataSource;
import io.blue.submarine.han.core.model.order.Order;
import io.blue.submarine.han.core.model.order.OrderItem;
import io.blue.submarine.han.core.model.user.User;
import io.blue.submarine.han.dao.mapper.order.OrderItemMapper;
import io.blue.submarine.han.dao.mapper.order.OrderMapper;
import io.blue.submarine.han.dao.mapper.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务接口实现类.
 *
 * @author shucunbin
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    @RouterDataSource(DataSource.MASTER)
    public User findByUserId(Integer userId) {
        return userMapper.findByUserId(userId);
    }

    @Override
    @RouterDataSource(DataSource.MASTER)
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
