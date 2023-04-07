package uz.pdp.dars1_vazifa2.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.dars1_vazifa2.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "warehouse")
public class Warehouse extends AbsEntity {

}
