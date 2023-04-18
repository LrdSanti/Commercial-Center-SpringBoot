package lrd.parcial.lord.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import lrd.parcial.lord.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    // Personalized query
    @Query(
            value = "SELECT * FROM customers cu LEFT JOIN orders ord ON cu.id = ord.customer_id",
    nativeQuery=true)
    public List<Object[]> filter();

}
