package Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundError extends Exception {

    public NotFoundError() {

    }

    public NotFoundError(String message) {
        super(message);
    }
}
