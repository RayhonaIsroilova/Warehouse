package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Warehouse;
import uz.pdp.appwahouse.projection.WarehouseCustom;

//@RepositoryRestResource(path = "warehouse",collectionResourceRel = "Rayhon",excerptProjection = WarehouseCustom.class)
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
    boolean existsByName(String name);
}
