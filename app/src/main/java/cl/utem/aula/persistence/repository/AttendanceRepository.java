package cl.utem.aula.persistence.repository;

import cl.utem.aula.persistence.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author seba
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
