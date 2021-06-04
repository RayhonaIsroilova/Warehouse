package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.InputProduct;
import uz.pdp.appwahouse.projection.InputProductCustom;

//@RepositoryRestResource(path = "inputProduct",collectionResourceRel = "Rayhon",excerptProjection = InputProductCustom.class)
@Repository
public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
