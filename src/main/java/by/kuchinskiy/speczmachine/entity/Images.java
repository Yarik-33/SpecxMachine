package by.kuchinskiy.speczmachine.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    @ManyToOne
    private Machine machine;
}