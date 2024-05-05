package diegosneves.github.cleanarchitecture.utils;

import diegosneves.github.cleanarchitecture.exception.UuidInvalidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class UuidUtilsTest {


    @Test
    void generateUuidShouldReturnValidUuid() {
        String uuid = UuidUtils.generateUuid();

        assertNotNull(uuid);
        assertFalse(uuid.isEmpty());
        assertTrue(UuidUtils.isValidUuid(uuid));
    }

    @Test
    void should() {
        String uuid = "4543jkljljfi34-sfigjkmnqlo";

        UuidInvalidException exception = assertThrows(UuidInvalidException.class, () -> UuidUtils.isValidUuid(uuid));

        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getCause().getClass());
        assertEquals(UuidInvalidException.ERROR.getMessage(uuid), exception.getMessage());
    }

}
