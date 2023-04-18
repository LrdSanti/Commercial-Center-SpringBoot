package lrd.parcial.lord.model.service.OrderImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lrd.parcial.lord.model.entity.Order;
import lrd.parcial.lord.model.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    OrderRepository repository;

    @Override
    public List<Order> printOrders() {
        return repository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        
        return repository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Order editOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
         repository.deleteById(id);
    }

    
}
