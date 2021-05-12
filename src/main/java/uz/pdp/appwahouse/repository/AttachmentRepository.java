package uz.pdp.appwahouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appwahouse.entity.Attachment;
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
