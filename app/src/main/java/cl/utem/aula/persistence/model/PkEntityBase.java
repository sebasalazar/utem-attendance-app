package cl.utem.aula.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Clase base de entidades con ID autoincrementable.
 */
@MappedSuperclass
public class PkEntityBase extends Utem {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk", nullable = false)
    private Long id = null;

    @Column(name = "created", nullable = false)
    protected OffsetDateTime created = OffsetDateTime.now();

    @Column(name = "updated", nullable = false)
    protected OffsetDateTime updated = OffsetDateTime.now();

    /**
     *
     * @return Identificador único autoincremental
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id Identificador único autoincremental
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return Fecha de creación
     */
    public OffsetDateTime getCreated() {
        return created;
    }

    /**
     *
     * @param created Fecha de creación
     */
    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    /**
     *
     * @return Fecha de última actualización
     */
    public OffsetDateTime getUpdated() {
        return updated;
    }

    /**
     *
     * @param updated Fecha de última actualización
     */
    public void setUpdated(OffsetDateTime updated) {
        this.updated = updated;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PkEntityBase other = (PkEntityBase) obj;
        return Objects.equals(this.id, other.id);
    }
}
