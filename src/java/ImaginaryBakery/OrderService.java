
package ImaginaryBakery;

import java.util.List;
 

public class OrderService {
    OrderDAO orderDao = new OrderDAO();
 
    public List<Order> getAllOrders() {
        List<Order> orderList = orderDao.getAllOrders();
        return orderList;
    }
 
    public Order getOrderForId(String id) {
        Order order = orderDao.getOrderForId(id);
        return order;
    }
 
    public Order createOrder(Order order) {
        Order orderResponse = orderDao.createOrder(order);
        return orderResponse;
    }
 
    public Order updateOrder(Order order) {
        Order orderResponse = orderDao.updateOrder(order);
        return orderResponse;
    }
 
    public Order deleteOrder(String id) {
        Order orderResponse = orderDao.deleteOrder(id);
        return orderResponse;
    }


 
}