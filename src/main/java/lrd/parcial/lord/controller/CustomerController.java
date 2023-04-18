package lrd.parcial.lord.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lrd.parcial.lord.model.entity.Customer;
import lrd.parcial.lord.model.service.CustomerImpl.CustomerService;

@Controller
public class CustomerController {
    
    private CustomerService service;

    public CustomerController(CustomerService service) {
        
        this.service = service;
    }

    @GetMapping({"/customer"})
    public String printCustomers(Model model) {

        Customer customer = new Customer();

        model.addAttribute("title", "CUSTOMERS MANAGEMENT");

        model.addAttribute("customer", customer);

        model.addAttribute("customers", service.printCustomers());

        return "customer/customer_inicio";
    }

    @GetMapping({"/filter"})
    public String filterCustomers(Model model) {

        List<Object[]> listaTemporal = new ArrayList();

        listaTemporal = service.filter();
        model.addAttribute("customers", listaTemporal);
        return "customer/customer_filter";
            
    }

    @PostMapping({"/register"})
    public String saveCustomer(Customer customer) {
        service.saveCustomer(customer);

        return "redirect:/customer";
    }
    
    @GetMapping("/customer/editar/{id}")
    public String showFormToEdit(@PathVariable Long id, Model model) {
    
        model.addAttribute("customer", service.getCustomerById(id));

        model.addAttribute("prueba", "texto de editar de prueba");
        return "customer/customer_editar";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute("customer") Customer customer, Model model) {

        Customer oldCustomer = service.getCustomerById(id);

        oldCustomer.setId(id);
        oldCustomer.setName(customer.getName());
        oldCustomer.setLastName1(customer.getLastName1());
        oldCustomer.setLastName2(customer.getLastName2());
        oldCustomer.setCity(customer.getCity());
        oldCustomer.setCategory(customer.getCategory());

        service.editCustomer(oldCustomer);

        return "redirect:/customer";
    }

    @GetMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "redirect:/customer";
    }

}
