package lrd.parcial.lord.model.service.OrderImpl;

import java.util.List;

import lrd.parcial.lord.model.entity.Order;

public interface OrderService {
    
    // List all Order
    public List<Order> printOrders();

    // Save a new Order
    public Order saveOrder(Order order);

    // Get a Order by its id
    public Order getOrderById(Long id);

    // Edit an already registered Order
    public Order editOrder(Order order);

    // Delete a Order
    public void deleteOrder(Long id);

}
