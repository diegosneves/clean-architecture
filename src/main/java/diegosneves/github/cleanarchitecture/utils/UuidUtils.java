package diegosneves.github.cleanarchitecture.utils;

import diegosneves.github.cleanarchitecture.exception.UuidInvalidException;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class UuidUtils {

    public static final String INVALID_UUID_ERROR = "O UUID [{}] é inválido";

    private UuidUtils() {
    }

    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidUuid(String uuid) throws UuidInvalidException {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException e) {
            log.warn(INVALID_UUID_ERROR, uuid, e);
            throw new UuidInvalidException(uuid, e);
        }
    }

}
