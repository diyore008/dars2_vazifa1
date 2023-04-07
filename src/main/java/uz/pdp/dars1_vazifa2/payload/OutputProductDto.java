package uz.pdp.dars1_vazifa2.payload;

import lombok.Data;

@Data
public class OutputProductDto {
    private Integer productId;
    private Double amount;
    private Double price;
    private Integer outputId;
}
