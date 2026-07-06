package repository;

import entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Leaverepository extends JpaRepository<Leave,Integer> {

}
