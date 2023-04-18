package lrd.parcial.lord.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "customers",
        indexes = { @Index(name = "index_name", columnList = "name"),
                    @Index(name = "index_fullname", columnList = "name, lastName1")
        }
        
)
        
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "User's name cannot be empty...")
    private String name;

    @NotEmpty(message = "User's lastname1 cannot be empty")
    private String lastName1;

    private String lastName2;

    private String city;

    private Long category;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Customer() {
        orders = new ArrayList();
    }


    public void addOrder(Order order) {
        orders.add(order);
    }
}
