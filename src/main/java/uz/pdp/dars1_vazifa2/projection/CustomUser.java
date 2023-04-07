package uz.pdp.dars1_vazifa2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.dars1_vazifa2.entity.User;

@Projection(types = User.class)
public interface CustomUser {
    Integer getId();
    String getFirstName();
    String getLastName();
    String getPhoneNumber();
    String getCode();
    String getPassword();
    boolean getActive();
}
