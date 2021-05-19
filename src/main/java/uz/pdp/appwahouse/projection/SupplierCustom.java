package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Supplier;

@Projection(types = Supplier.class)
public interface SupplierCustom {

    Integer getId();

    String getName();

    boolean getActive();

    String getPhoneNumber();


}
