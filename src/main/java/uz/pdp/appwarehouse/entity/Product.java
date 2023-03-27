package uz.pdp.appwarehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product extends AbsEntity {
    @ManyToOne(optional = false)
    private Category category;
    @OneToOne
    private Attachment attachment;
    private String code;
    @ManyToOne(optional = false)
    private Measurement measurement;
}
