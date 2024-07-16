package rest.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GroupNotFoundException extends RuntimeException{
    private String message;
    private static final Long SERIAL_VERSION_UID = 1L;

    public GroupNotFoundException(String message){
        this.message = message;
    }

}
