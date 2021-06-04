package uz.pdp.appwahouse.payload;

import lombok.Data;

@Data
public class ProductDTO {
    private String code,name;
    private Integer categoryId;
    private Integer MeasurementId;
    private Integer photoId;

}
