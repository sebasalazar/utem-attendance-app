package cl.utem.aula.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

/**
 *
 * @author seba
 */
@Entity
@Table(name = "attendances")
public class Attendance extends PkEntityBase {

    @JoinColumn(name = "person_fk",referencedColumnName = "pk")
    @ManyToOne 
    private Person person = null;
    
    @JoinColumn(name = "room_fk",referencedColumnName = "pk")
    @ManyToOne
    private Room room = null;
    
    @Column(name="attendance_date")
    private OffsetDateTime date = null;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }
}
