package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.OutputProduct;
import uz.pdp.appwahouse.projection.OutputProductCustom;

//@RepositoryRestResource(path = "outputProduct",collectionResourceRel = "Rayhon",excerptProjection = OutputProductCustom.class)
@Repository
public interface OutputProductRepository extends JpaRepository<OutputProduct,Integer> {
}
