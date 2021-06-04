package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Category;
import uz.pdp.appwahouse.entity.Measurement;

//@RepositoryRestResource(path = "category",collectionResourceRel = "Rayhon",excerptProjection = uz.pdp.appwahouse.projection.Category.class)
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    boolean existsByName(String name);

}
