package lrd.parcial.lord.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lrd.parcial.lord.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{
    
}
