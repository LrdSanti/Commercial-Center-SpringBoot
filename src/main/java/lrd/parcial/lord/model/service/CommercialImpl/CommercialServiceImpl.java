package lrd.parcial.lord.model.service.CommercialImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lrd.parcial.lord.model.entity.Commercial;
import lrd.parcial.lord.model.repository.CommercialRepository;

@Service
public class CommercialServiceImpl implements CommercialService {

    @Autowired
    CommercialRepository repository;
    
    @Override
    public List<Commercial> printCommercials() {
        
        return repository.findAll();

    }

    @Override
    public Commercial saveCommercials(Commercial commercial) {
        
        return repository.save(commercial);
    }

    @Override
    public Commercial getCommercialsById(Long id) {
        
        return repository.findById(id).get();
    }

    @Override
    public Commercial editCommercials(Commercial commercial) {
        
        return repository.save(commercial);
    }

    @Override
    public void deleteCommercials(Long id) {
       repository.deleteById(id);
    }
    
}
