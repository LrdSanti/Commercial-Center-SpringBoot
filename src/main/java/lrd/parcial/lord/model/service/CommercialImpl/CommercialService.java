package lrd.parcial.lord.model.service.CommercialImpl;

import java.util.List;

import lrd.parcial.lord.model.entity.Commercial;

public interface CommercialService {
    

    // List all Order
    public List<Commercial> printCommercials();

    // Save a new Order
    public Commercial saveCommercials(Commercial commercial);

    // Get a Order by its id
    public Commercial getCommercialsById(Long id);

    // Edit an already registered Order
    public Commercial editCommercials(Commercial commercial);

    // Delete a Order
    public void deleteCommercials(Long id);

}
