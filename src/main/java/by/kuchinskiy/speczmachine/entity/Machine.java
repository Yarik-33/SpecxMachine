package by.kuchinskiy.speczmachine.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="machines")
@Data
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OrderColumn(name = "name")
    private String name;
    @OrderColumn(name = "price")
    private Long price;
    @OneToMany(mappedBy = "machine",  cascade = CascadeType.ALL)
    private List<Images> images = new ArrayList<>();

}
