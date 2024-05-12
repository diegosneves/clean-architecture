package diegosneves.github.cleanarchitecture.exception;

import diegosneves.github.cleanarchitecture.exception.shared.ExceptionDetails;

public class CustomerException extends RuntimeException {

    public static final ExceptionDetails ERROR = ExceptionDetails.CUSTOMER_CREATION_FAILURE;

    public CustomerException(String message) {
        super(ERROR.getMessage(message));
    }
}
