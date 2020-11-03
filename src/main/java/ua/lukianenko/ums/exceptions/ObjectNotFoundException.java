package ua.lukianenko.ums.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ObjectNotFoundException extends RuntimeException {
    private Long objectId;
    private Class objectClass;
}
