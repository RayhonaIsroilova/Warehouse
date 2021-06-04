package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Currency;
import uz.pdp.appwahouse.projection.CurrencyCustom;

//@RepositoryRestResource(path = "currency",collectionResourceRel = "Rayhon",excerptProjection = CurrencyCustom.class)
@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    boolean existsByName(String name);
}
