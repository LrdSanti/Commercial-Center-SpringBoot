package lrd.parcial.lord.model.service.CustomerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lrd.parcial.lord.model.entity.Customer;
import lrd.parcial.lord.model.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> printCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Customer editCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Object[]> filter() {
        
        return repository.filter();
    }
    
}
