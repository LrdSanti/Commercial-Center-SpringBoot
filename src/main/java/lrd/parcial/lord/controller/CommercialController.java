package lrd.parcial.lord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lrd.parcial.lord.model.entity.Commercial;
import lrd.parcial.lord.model.service.CommercialImpl.CommercialService;

@Controller
public class CommercialController {
    
    private CommercialService service;

    public CommercialController(CommercialService service) {

        this.service = service;
    }


    @GetMapping({"/commercial"})
    public String printCommercials(Model model) {

        Commercial commercial = new Commercial();

        model.addAttribute("commercial", commercial);

        model.addAttribute("commercials", service.printCommercials());

        return "commercial/commercial_start";
    }
    
    @PostMapping({"/savecommercial"})
    public String saveCommercial(Commercial commercial) {

        service.saveCommercials(commercial);
        return "redirect:/commercial";
    }
    
    @GetMapping("/commercial/edit/{id}")
    public String showFormToEdit(@PathVariable Long id, Model model) {

        model.addAttribute("commercial", service.getCommercialsById(id));

        return "commercial/commercial_edit";
    }

    @PostMapping("/commercial/{id}")
    public String updateCommercial(@PathVariable Long id, @ModelAttribute("commercial") Commercial comercial,
            Model model) {

        Commercial oldCommercial = service.getCommercialsById(id);

        oldCommercial.setId(id);
        oldCommercial.setName(comercial.getName());
        oldCommercial.setLastName1(comercial.getLastName1());
        oldCommercial.setLastName2(comercial.getLastName2());
        oldCommercial.setCity(comercial.getCity());
        oldCommercial.setCharge(comercial.getCharge());

        service.editCommercials(oldCommercial);

        return "redirect:/commercial";
    }

    @GetMapping("/commercial/delete/{id}")
    public String deleteCommercial(@PathVariable Long id) {
        service.deleteCommercials(id);
        return "redirect:/commercial";
    }


}
