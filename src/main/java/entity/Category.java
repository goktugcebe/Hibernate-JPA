package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name = "category")
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "category_name",length = 50)
    private String category_name;

    @OneToMany(mappedBy = "category")
    private Set<Book> book;

}
