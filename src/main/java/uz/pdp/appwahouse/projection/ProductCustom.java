package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Attachment;
import uz.pdp.appwahouse.entity.Category;
import uz.pdp.appwahouse.entity.Measurement;
import uz.pdp.appwahouse.entity.Product;

@Projection(types = Product.class)
public interface ProductCustom {

    Integer getId();

    String getName();

    boolean getActive();

    Category getCategory();


    Attachment getPhoto();


    Measurement getMeasurement();

    String getCode();
}
