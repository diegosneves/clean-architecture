package diegosneves.github.cleanarchitecture.exception;

import diegosneves.github.cleanarchitecture.exception.shared.ExceptionDetails;

public class UuidInvalidException extends RuntimeException {

    public static final ExceptionDetails ERROR = ExceptionDetails.INVALID_UUID_FORMAT_MESSAGE;

    public UuidInvalidException(String message, Throwable cause) {
        super(ERROR.getMessage(message), cause);
    }

}
