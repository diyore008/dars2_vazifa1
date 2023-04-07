package uz.pdp.dars1_vazifa2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.dars1_vazifa2.entity.*;

import java.sql.Timestamp;
import java.util.Date;

@Projection(types = Output.class)
public interface CustomOutput {
    Integer getId();
    Timestamp getDate();
    Warehouse getWarehouse();
    Client getClient();
    String getFactureNumber();
    String getCode();
}
