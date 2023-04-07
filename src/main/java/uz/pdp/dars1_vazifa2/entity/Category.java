package uz.pdp.dars1_vazifa2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.dars1_vazifa2.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "category")
public class Category extends AbsEntity {

    @ManyToOne
    private Category parentCategory;


}
