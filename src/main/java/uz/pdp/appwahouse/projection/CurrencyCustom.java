package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwahouse.entity.Currency;

@Projection(types = Currency.class)
public interface CurrencyCustom {

    Integer getId();

    String getName();

    boolean getActive();
}
