package uz.pdp.appwahouse.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InputDTO {
    private Timestamp date;
    private String code,factureNumber;
    private Integer warehouseId;
    private Integer supplierId;
    private Integer currencyId;
}
