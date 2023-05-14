package cl.utem.aula.api;

import cl.utem.aula.vo.ErrorVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author seba
 */
@RestControllerAdvice
public class AulaExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AulaExceptionHandler.class);

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorVO> handle(Exception e) {
        LOGGER.error("Error desconocido: {}", e.getLocalizedMessage());
        LOGGER.debug("Error desconocido: {}", e.getMessage(), e);
        ErrorVO error = new ErrorVO("Error desconocido");
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(error, status);
    }
}
