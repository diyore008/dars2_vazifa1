package uz.pdp.dars1_vazifa2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.dars1_vazifa2.entity.Client;

@Projection(types = Client.class)
public interface CustomClient {
    Integer getId();
    String getName();
    boolean getActive();
    String getPhoneNumber();
}
