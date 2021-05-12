package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
