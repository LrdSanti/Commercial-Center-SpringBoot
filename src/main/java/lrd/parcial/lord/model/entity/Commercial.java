package lrd.parcial.lord.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name= "commercials")
public class Commercial {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName1;


    private String lastName2;


    private String city;

    private Float charge;


    @OneToMany(mappedBy = "commercial", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Commercial() {
        orders = new ArrayList();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    

}
