package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.entity.Output;
import uz.pdp.appwahouse.projection.OutputCustom;

//@RepositoryRestResource(path = "output",collectionResourceRel = "Rayhon",excerptProjection = OutputCustom.class)
@Repository
public interface OutputRepository extends JpaRepository<Output,Integer> {

    boolean existsByCode(String code);
}
