package uz.pdp.dars1_vazifa2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.dars1_vazifa2.entity.Attachment;
import uz.pdp.dars1_vazifa2.entity.Category;
import uz.pdp.dars1_vazifa2.entity.Measurement;
import uz.pdp.dars1_vazifa2.entity.template.AbsEntity;

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
