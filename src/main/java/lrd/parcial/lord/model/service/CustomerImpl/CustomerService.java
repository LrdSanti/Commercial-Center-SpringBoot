package lrd.parcial.lord.model.service.CustomerImpl;

import java.util.List;

import lrd.parcial.lord.model.entity.Customer;

public interface CustomerService {
    
    // List all customers
    public List<Customer> printCustomers();

    // Save a new Customer
    public Customer saveCustomer(Customer customer);

    // Get a customer by its id
    public Customer getCustomerById(Long id);

    // Edit an already registered customer
    public Customer editCustomer(Customer customer);

    // Delete a customer
    public void deleteCustomer(Long id);


    // Personalized query 
    public List<Object[]> filter();
}
