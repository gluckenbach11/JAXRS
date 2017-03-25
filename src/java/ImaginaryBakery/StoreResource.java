
package ImaginaryBakery;

import java.util.List;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
 
@Path("/orderInfo")
public class StoreResource {
    OrderService orderService = new OrderService();
 
    // -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Order createOrder(Order order) {
        Order orderResponse = orderService.createOrder(order);
        return orderResponse;
    }
 
    // -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        return orderList;
    }
 
    // -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrderForId(@PathParam("id") String id) {
        Order order = orderService.getOrderForId(id);
        return order;
    }
 
    // -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Order updateOrder(Order order) {
        Order orderResponse = orderService.updateOrder(order);
        return orderResponse;
    }
 
    // -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order deleteeOrder(@PathParam("id") String id) {
        Order orderResponse = orderService.deleteOrder(id);
        return orderResponse;
    }
}
