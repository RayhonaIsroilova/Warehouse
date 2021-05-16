package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.OutputProduct;

@Projection(types = OutputProduct.class)
public interface OutputProductCustom {

    Integer getId();
}
