package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Input;
import uz.pdp.appwahouse.entity.Output;

@Repository
public interface OutputRepository extends JpaRepository<Output,Integer> {

    boolean existsByCode(String code);
}
