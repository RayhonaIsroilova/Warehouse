package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Product;
import uz.pdp.appwahouse.projection.ProductCustom;

//@RepositoryRestResource(path = "product",collectionResourceRel = "Rayhon",excerptProjection = ProductCustom.class)
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
boolean existsByName(String name);

}
