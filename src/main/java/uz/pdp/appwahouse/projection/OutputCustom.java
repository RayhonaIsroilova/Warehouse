package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Output;

@Projection(types = Output.class)
public interface OutputCustom {

    Integer getId();
}
