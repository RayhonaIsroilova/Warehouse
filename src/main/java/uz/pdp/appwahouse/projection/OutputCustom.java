package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Client;
import uz.pdp.appwahouse.entity.Currency;
import uz.pdp.appwahouse.entity.Output;
import uz.pdp.appwahouse.entity.Warehouse;

import java.sql.Timestamp;

@Projection(types = Output.class)
public interface OutputCustom {

    Integer getId();

    Timestamp getDate();

    Warehouse getWarehouse();

    Client getClient();

    Currency getCurrency();

    String getCode();

    String getFactureNumber();
}
