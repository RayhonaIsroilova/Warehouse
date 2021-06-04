package uz.pdp.appwahouse.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OutputDTO {
    private Timestamp date;
    private String code,factureNumber;
    private Integer warehouseId;
    private Integer clientId;
    private Integer currencyId;
}
