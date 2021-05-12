package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
boolean existsByName(String name);

}
