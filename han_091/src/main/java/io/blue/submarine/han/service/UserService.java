package io.blue.submarine.han.service;

import io.blue.submarine.han.core.model.order.Order;
import io.blue.submarine.han.core.model.user.User;
import org.apache.ibatis.annotations.Param;

/**
 * 订单服务接口.
 *
 * @author shucunbin
 */
public interface UserService {
    int insert(User user);

    User findByUserId(Integer userId);

    User findByName(String name);
}
