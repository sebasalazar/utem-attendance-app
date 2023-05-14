package cl.utem.aula.api.v1;

import cl.utem.aula.persistence.model.Attendance;
import cl.utem.aula.persistence.model.Person;
import cl.utem.aula.persistence.model.Room;
import cl.utem.aula.persistence.repository.AttendanceRepository;
import cl.utem.aula.persistence.repository.PersonRepository;
import cl.utem.aula.persistence.repository.RoomRepository;
import cl.utem.aula.vo.AttendanceVO;
import java.time.OffsetDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author seba
 */
@RestController
@RequestMapping(value = {"/v1"},
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class AttendanceRest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostMapping(value = "/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity register(@RequestBody AttendanceVO body) {

        Person person = personRepository.findByRut(body.getRut());
        Room room = roomRepository.findByCodeIgnoreCase(body.getCode());

        Attendance attendance = new Attendance();
        attendance.setPerson(person);
        attendance.setRoom(room);
        attendance.setDate(body.getDate());
        attendanceRepository.saveAndFlush(attendance);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
