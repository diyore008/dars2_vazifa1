package uz.pdp.dars1_vazifa2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.dars1_vazifa2.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "measurement")
public class Measurement extends AbsEntity {


}
