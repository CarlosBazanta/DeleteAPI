package delete_and_add.delete_and_add.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionService extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionService(String message){
        super(message);
    }

}
