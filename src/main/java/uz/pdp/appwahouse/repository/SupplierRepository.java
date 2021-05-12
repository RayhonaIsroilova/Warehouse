package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwahouse.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    boolean existsByNameAndPhoneNumber(String name, String phoneNumber);
    boolean existsByPhoneNumber(String phoneNumber);
}
