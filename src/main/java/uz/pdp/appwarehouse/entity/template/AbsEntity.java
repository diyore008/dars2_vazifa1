package uz.pdp.appwarehouse.entity.template;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.web.service.annotation.GetExchange;

@Data
@MappedSuperclass
public class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean active;

}
