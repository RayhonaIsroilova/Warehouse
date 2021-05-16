package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Product;

@Projection(types = Product.class)
public interface ProductCustom {

    Integer getId();
}
