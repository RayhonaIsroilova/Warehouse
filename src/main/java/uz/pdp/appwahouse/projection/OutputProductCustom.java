package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Output;
import uz.pdp.appwahouse.entity.OutputProduct;
import uz.pdp.appwahouse.entity.Product;

@Projection(types = OutputProduct.class)
public interface OutputProductCustom {

    Integer getId();

    Product getProduct();

    Double getAmount();

    Double getPrice();

    Output getOutput();
}
