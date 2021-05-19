package uz.pdp.appwahouse.projection;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface Category {

    Integer getId();

    String getName();

    boolean getActive();

    Category getParentCategory();
}
