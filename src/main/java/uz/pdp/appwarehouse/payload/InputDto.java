package uz.pdp.appwarehouse.payload;

import lombok.Data;
import uz.pdp.appwarehouse.entity.Supplier;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class InputDto {
    private Timestamp date;
    private Integer warehouseId;
    private Integer supplierId;
    private String factureNumber;
    private String code;
}
