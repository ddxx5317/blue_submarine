package io.blue.submarine.han;

import io.blue.submarine.han.core.model.order.Order;
import io.blue.submarine.han.core.model.order.OrderItem;
import io.blue.submarine.han.core.model.user.User;
import io.blue.submarine.han.dao.mapper.user.UserMapper;
import io.blue.submarine.han.service.OrderService;
import io.blue.submarine.han.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.Resource;
import java.util.List;

/**
 * 启动类.
 *
 * @author shucunbin
 */
@SpringBootApplication
public class Han091Application implements CommandLineRunner {
    @Resource
    private OrderService orderService;

    @Resource
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(Han091Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Order order = new Order();
        order.setOrderId(2);
        order.setUserId(1);
        order.setStatus("1");
        //orderService.save(order);

       //orderService.complexProcess();

        User user = new User();
        user.setUserId(9);
        user.setName("ZhangSan");
        //userService.insert(user);


        //final Order o = orderService.findByOrderIdFromMaster(1L);
        //System.out.println(o);
        //final List<OrderItem> orderItems = o.getOrderItems();
        //System.out.println(orderItems);

        //System.out.println(userService.findByUserId(9));
        System.out.println(userService.findByName("ZhangSan"));
    }
}
