package uz.pdp.dars1_vazifa2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.dars1_vazifa2.entity.Input;
import uz.pdp.dars1_vazifa2.entity.Output;
import uz.pdp.dars1_vazifa2.entity.OutputProduct;
import uz.pdp.dars1_vazifa2.entity.Product;

import java.util.Date;

@Projection(types = OutputProduct.class)
public interface CustomOutputProduct {
    Integer getId();
    Product getProduct();
    Double getAmount();
    Double getPrice();
    Output getOutput();
}
