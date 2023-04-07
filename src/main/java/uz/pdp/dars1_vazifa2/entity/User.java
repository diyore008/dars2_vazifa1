package uz.pdp.dars1_vazifa2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column()
    private String firstName;
    @Column()
    private String lastName;
    @Column(unique = true )
    private String phoneNumber;
    @Column()
    private String code;
    @Column()
    private String password;
    private boolean active = true;

    @ManyToMany
    private Set<Warehouse> warehouses;
}
