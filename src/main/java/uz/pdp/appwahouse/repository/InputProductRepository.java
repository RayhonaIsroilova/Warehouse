package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.InputProduct;
@Repository
public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
