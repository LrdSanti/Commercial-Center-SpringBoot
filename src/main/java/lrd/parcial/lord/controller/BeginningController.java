package lrd.parcial.lord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BeginningController {
    
    
    @GetMapping("/")
    public String showBeginnin(Model model) {
        
        model.addAttribute("titulo", "Comercial | Pedidos");
        return "inicio";
    }
}
