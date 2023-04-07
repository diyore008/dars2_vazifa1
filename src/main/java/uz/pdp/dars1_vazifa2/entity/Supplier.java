package uz.pdp.dars1_vazifa2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.dars1_vazifa2.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="supplier")
public class Supplier extends AbsEntity {
    @Column(unique = true)
    private String phoneNumber;
}
