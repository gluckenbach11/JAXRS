
package ImaginaryBakery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OrderDAO {
    static HashMap<String, Order> ordersMap = new HashMap<String, Order>();
 
    public OrderDAO() {
            Order order1 = new Order();
            order1.setId("1");
            order1.setPrice(5);
            order1.setItem("Cupcake");
            
            Order order2 = new Order();
            order2.setId("2");
            order2.setPrice(21);
            order2.setItem("Bundt cake");
            
            ordersMap.put("1", order1);
            ordersMap.put("2", order2);
    }
 
    public List<Order> getAllOrders() {
 
        List<Order> orderList = new ArrayList<Order>(ordersMap.values());
        return orderList;
    }
 
    public Order getOrderForId(String id) {
        Order order = ordersMap.get(id);
        return order;
    }
 
    public Order createOrder(Order order) {
        ordersMap.put(order.getId(), order);
        return ordersMap.get(order.getId());
    }
 
    public Order updateOrder(Order order) {
        if (ordersMap.get(order.getId()) != null) {
            ordersMap.get(order.getId()).setItem(order.getItem());
        } else {
            ordersMap.put(order.getId(), order);
        }
        return ordersMap.get(order.getId());
    }
 
    public Order deleteOrder(String id) {
        Order orderResponse = ordersMap.remove(id);
        return orderResponse;
    }
 
}