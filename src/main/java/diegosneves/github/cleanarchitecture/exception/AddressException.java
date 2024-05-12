package diegosneves.github.cleanarchitecture.exception;

import diegosneves.github.cleanarchitecture.exception.shared.ExceptionDetails;

public class AddressException extends RuntimeException {

    public static final ExceptionDetails ERROR = ExceptionDetails.ADDRESS_CREATION_FAILURE;

    public AddressException(String message) {
        super(ERROR.getMessage(message));
    }
}
