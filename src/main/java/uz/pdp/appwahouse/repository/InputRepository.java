package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.projection.InputCustom;

//@RepositoryRestResource(path = "input",collectionResourceRel = "Rayhon",excerptProjection = InputCustom.class)
@Repository
public interface InputRepository extends JpaRepository<Input,Integer> {

    boolean existsByCode(String code);
}
