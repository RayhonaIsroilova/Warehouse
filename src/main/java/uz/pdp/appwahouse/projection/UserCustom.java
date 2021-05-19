package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.User;
import uz.pdp.appwahouse.entity.Warehouse;

import java.util.Set;

@Projection(types = User.class)
public interface UserCustom {

    Integer getId();

    String getFirstName();

    String getLastName();

    String getPhoneNumber();

    String getCode();

    String getPassword();

    boolean getActive();

    Set<Warehouse> getWarehouses();
}
