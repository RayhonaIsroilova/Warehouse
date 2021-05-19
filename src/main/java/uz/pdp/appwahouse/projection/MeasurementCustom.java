package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Measurement;

@Projection(types = Measurement.class)
public interface MeasurementCustom {

    Integer getId();

    String getName();

    boolean getActive();
}
