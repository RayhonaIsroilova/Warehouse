package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Client;
import uz.pdp.appwahouse.projection.ClientCustom;

//@RepositoryRestResource(path = "client",collectionResourceRel = "Rayhon",excerptProjection = ClientCustom.class)
@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
