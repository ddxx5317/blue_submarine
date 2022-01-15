package io.blue.submarine.han.service;

import io.blue.submarine.han.aop.DataSource;
import io.blue.submarine.han.aop.RouterDataSource;
import io.blue.submarine.han.core.model.order.Order;
import io.blue.submarine.han.core.model.order.OrderItem;
import io.blue.submarine.han.dao.mapper.order.OrderItemMapper;
import io.blue.submarine.han.dao.mapper.order.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单服务接口实现类.
 *
 * @author shucunbin
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public int save(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Order findByOrderId(Long orderId) {
        return orderMapper.findByOrderId(orderId.intValue());
    }

    @Override
    @RouterDataSource(DataSource.MASTER)
    public Order findByOrderIdFromMaster(Long orderId) {
        return orderMapper.findByOrderId(orderId.intValue());
    }

    @Override
    public void complexProcess() {
        batchSave();
    }


    private List<Long> batchSave() {
        List<Long> orderIdList = new ArrayList<>();
        for(Integer i = 1; i <= 2; i ++) {
            Order order = new Order();
            order.setOrderId(i);
            order.setUserId(i);
            order.setStatus("New");
            orderMapper.insert(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(Long.valueOf(order.getOrderId()));
            orderItem.setUserId(Long.valueOf(i));
            orderItem.setStatus("New");
            orderItemMapper.insert(orderItem);
        }
        return orderIdList;
    }
}
