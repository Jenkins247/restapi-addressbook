package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.model.GroupEntity;

@Repository
public interface DbRepository extends JpaRepository<GroupEntity, Integer> {
}
