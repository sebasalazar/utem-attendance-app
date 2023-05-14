package cl.utem.aula.persistence.repository;

import cl.utem.aula.persistence.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author seba
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    public Room findByCodeIgnoreCase(String code);
}
