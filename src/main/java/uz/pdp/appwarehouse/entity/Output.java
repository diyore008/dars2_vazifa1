package uz.pdp.appwarehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "output")
public class Output {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private Timestamp date;
    @ManyToOne
    private Warehouse warehouse;
    @ManyToOne
    private Client client;
    private String factureNumber;
    @Column(unique = true, nullable = false)
    private String code;
}
