package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Client;

@Projection(types = Client.class)
public interface ClientCustom {

    Integer getId();

    String getName();

    boolean getActive();

    String getPhoneNumber();
}
