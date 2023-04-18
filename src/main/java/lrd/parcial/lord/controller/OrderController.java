package lrd.parcial.lord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lrd.parcial.lord.model.entity.Order;
import lrd.parcial.lord.model.service.CommercialImpl.CommercialService;
import lrd.parcial.lord.model.service.CustomerImpl.CustomerService;
import lrd.parcial.lord.model.service.OrderImpl.OrderService;

@Controller
public class OrderController {
    
    private OrderService service;
    
    private CustomerService cuService;
    private CommercialService comService;

    public OrderController(OrderService service, CustomerService cuService, CommercialService comService) {
        this.service = service;
        this.cuService = cuService;
        this.comService = comService;
    }

    @GetMapping("/order")
    public String printAllOrders(Model model) {

        Order order = new Order();

        model.addAttribute("order", order);
        model.addAttribute("orders", service.printOrders());

        model.addAttribute("customers", cuService.printCustomers());

        return "order/order_inicio";
    }
    
    @GetMapping("/order/new")
    public String showRegisterForm(Model model) {

        Order order = new Order();

        model.addAttribute("order", order);
        model.addAttribute("orders", service.printOrders());

        model.addAttribute("customers", cuService.printCustomers());

        model.addAttribute("commercials", comService.printCommercials());

        return "order/order_registrar";
    }
    
    @PostMapping({"/saveorder"})
    public String saveOrder(Order order){

        service.saveOrder(order);

        return "redirect:/order";
    }

}
