package cl.utem.aula.persistence.repository;

import cl.utem.aula.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author seba
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public Person findByRut(Long rut);
}
