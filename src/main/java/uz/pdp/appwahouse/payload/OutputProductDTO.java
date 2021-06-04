package uz.pdp.appwahouse.payload;

import lombok.Data;

import java.sql.Date;


@Data
public class OutputProductDTO {
    private Double amount;
    private Double price;
    private Integer productId;
    private Integer outputId;
}
