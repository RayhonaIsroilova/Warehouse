package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.User;
import uz.pdp.appwahouse.projection.UserCustom;

//@RepositoryRestResource(path = "users",collectionResourceRel = "Rayhon",excerptProjection = UserCustom.class)
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
