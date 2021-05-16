package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Input;

@Projection(types = Input.class)
public interface InputCustom {

    Integer getId();
}
