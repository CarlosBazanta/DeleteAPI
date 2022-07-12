package delete_and_add.delete_and_add.repository;

import delete_and_add.delete_and_add.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface WorkRepository extends JpaRepository<UserEntity, Long> {
}
