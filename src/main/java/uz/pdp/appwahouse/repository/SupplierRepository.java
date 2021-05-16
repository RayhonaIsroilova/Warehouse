package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appwahouse.entity.Supplier;
import uz.pdp.appwahouse.projection.SupplierCustom;

@RepositoryRestResource(path = "supplier",collectionResourceRel = "Rayhon",excerptProjection = SupplierCustom.class)
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
//    boolean existsByNameAndPhoneNumber(String name, String phoneNumber);
//    boolean existsByPhoneNumber(String phoneNumber);
}
