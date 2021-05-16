package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.InputProduct;

@Projection(types = InputProduct.class)
public interface InputProductCustom {

    Integer getId();
}
