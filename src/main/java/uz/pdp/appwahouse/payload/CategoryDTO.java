package uz.pdp.appwahouse.payload;

import lombok.Data;

@Data
public class CategoryDTO {
    private String name;
    private Integer parentCategoryId;
}
