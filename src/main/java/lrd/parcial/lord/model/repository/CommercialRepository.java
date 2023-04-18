package lrd.parcial.lord.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lrd.parcial.lord.model.entity.Commercial;

@Repository
public interface CommercialRepository extends JpaRepository <Commercial, Long> {
    
}
