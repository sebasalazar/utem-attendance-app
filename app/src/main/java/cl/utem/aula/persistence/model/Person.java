package cl.utem.aula.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author seba
 */
@Entity
@Table(name = "persons")
public class Person extends PkEntityBase {

    @Column(name = "rut")
    private Long rut = null;

    @Column(name = "name")
    private String name = null;

    public Long getRut() {
        return rut;
    }

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
