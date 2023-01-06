package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "address")
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "street",length = 100,nullable = false)
    private String street;

    @Column(name = "zipcode")
    private int zipCode;

    @OneToOne(mappedBy = "address")
    private Author author;


}
