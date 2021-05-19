package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Warehouse;

@Projection(types = Warehouse.class)
public interface WarehouseCustom {

    Integer getId();

    String getName();

    boolean getActive();
}
