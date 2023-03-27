package uz.pdp.appwarehouse.payload;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import uz.pdp.appwarehouse.entity.Warehouse;

import java.util.Set;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String code;

    private String password;

    private Integer[] warehousesId;
}
