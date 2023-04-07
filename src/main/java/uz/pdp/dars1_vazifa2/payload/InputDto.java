package uz.pdp.dars1_vazifa2.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InputDto {
    private Timestamp date;
    private Integer warehouseId;
    private Integer supplierId;
    private String factureNumber;
    private String code;
}
