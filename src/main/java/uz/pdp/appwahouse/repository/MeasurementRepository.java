package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Measurement;
import uz.pdp.appwahouse.projection.MeasurementCustom;

//@RepositoryRestResource(path = "measurement",collectionResourceRel = "Rayhon",excerptProjection = MeasurementCustom.class)
@Repository
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

    boolean existsByName(String name);

}
