package cl.utem.aula.vo;

import cl.utem.aula.persistence.model.Utem;

/**
 *
 * @author seba
 */
public class ErrorVO extends Utem {

    private String message = null;

    public ErrorVO() {
    }
    
    public ErrorVO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
