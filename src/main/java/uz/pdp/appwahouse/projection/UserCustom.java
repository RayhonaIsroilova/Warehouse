package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.User;

@Projection(types = User.class)
public interface UserCustom {

    Integer getId();
}
