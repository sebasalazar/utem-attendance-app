package cl.utem.aula.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author seba
 */
@Entity
@Table(name = "rooms")
public class Room extends PkEntityBase {

    @Column(name = "code")
    private String code = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
