package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.entity.InputProduct;
import uz.pdp.appwahouse.entity.Product;

import java.sql.Date;

@Projection(types = InputProduct.class)
public interface InputProductCustom {

    Integer getId();

    Product getProduct();

    Double getAmount();

    Date getExpireDate();

    Input getInput();
}
