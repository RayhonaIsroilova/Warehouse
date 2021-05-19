package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Currency;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.entity.Supplier;
import uz.pdp.appwahouse.entity.Warehouse;

import java.sql.Timestamp;

@Projection(types = Input.class)
public interface InputCustom {

    Integer getId();

    Timestamp getDate();

    Warehouse getWarehouse();

    Supplier getSupplier();

    Currency getCurrency();

    String getCode();

    String  getFactureNumber();
}
