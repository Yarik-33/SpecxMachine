package by.kuchinskiy.speczmachine.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}