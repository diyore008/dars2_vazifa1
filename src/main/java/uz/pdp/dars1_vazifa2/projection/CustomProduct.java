package uz.pdp.dars1_vazifa2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.dars1_vazifa2.entity.Attachment;
import uz.pdp.dars1_vazifa2.entity.Category;
import uz.pdp.dars1_vazifa2.entity.Measurement;
import uz.pdp.dars1_vazifa2.entity.Product;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();
    String getName();
    boolean getActive();
    Category getCategory();
    Attachment getAttachment();
    String getCode();
    Measurement getMeasurement();
}
