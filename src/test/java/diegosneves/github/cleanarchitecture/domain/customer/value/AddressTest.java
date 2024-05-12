package diegosneves.github.cleanarchitecture.domain.customer.value;

import diegosneves.github.cleanarchitecture.exception.AddressException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AddressTest {

    private Address address;

    @BeforeEach
    void setUp() {
        this.address = new Address("Rua", "377", "93200200", "Cidade");
    }

    @Test
    void shouldCreateAddress() {
        this.address = new Address("Rua", "377", "93200200", "Cidade");

        assertNotNull(address);
        assertEquals("Rua", this.address.getStreet());
        assertEquals("377", this.address.getNumber());
        assertEquals("93200200", this.address.getZipCode());
        assertEquals("Cidade", this.address.getCity());
    }

    @Test
    void shouldNotCreateAddressWithNullStreet() {
        AddressException exception = assertThrows(AddressException.class, () -> this.address = new Address(null, "377", "93200200", "Cidade"));

        assertNotNull(exception);
        assertEquals(AddressException.ERROR.getMessage(Address.STREET_REQUIRED), exception.getMessage());
    }

    @Test
    void shouldNotCreateAddressWithEmptyStreet() {
        AddressException exception = assertThrows(AddressException.class, () -> this.address = new Address(" ", "377", "93200200", "Cidade"));

        assertNotNull(exception);
        assertEquals(AddressException.ERROR.getMessage(Address.STREET_REQUIRED), exception.getMessage());
    }

    @Test
    void shouldNotCreateAddressWithNullNumber() {
        AddressException exception = assertThrows(AddressException.class, () -> this.address = new Address("Rua", null, "93200200", "Cidade"));

        assertNotNull(exception);
        assertEquals(AddressException.ERROR.getMessage(Address.RESIDENCE_NUMBER_REQUIRED), exception.getMessage());
    }

    @Test
    void shouldNotCreateAddressWithEmptyNumber() {
        AddressException exception = assertThrows(AddressException.class, () -> this.address = new Address("Rua", "", "93200200", "Cidade"));

        assertNotNull(exception);
        assertEquals(AddressException.ERROR.getMessage(Address.RESIDENCE_NUMBER_REQUIRED), exception.getMessage());
    }

    @Test
    void shouldNotCreateAddressWithNullZipCode() {
        AddressException exception = assertThrows(AddressException.class, () -> this.address = new Address("null", "377", null, "Cidade"));

        assertNotNull(exception);
        assertEquals(AddressException.ERROR.getMessage(Address.ZIP_CODE_REQUIRED), exception.getMessage());
    }

    @Test
    void shouldNotCreateAddressWithEmptyZipCode() {
        AddressException exception = assertThrows(AddressException.class, () -> this.address = new Address("Rua", "377", " ", "Cidade"));

        assertNotNull(exception);
        assertEquals(AddressException.ERROR.getMessage(Address.ZIP_CODE_REQUIRED), exception.getMessage());
    }

    @Test
    void shouldNotCreateAddressWithNullCity() {
        AddressException exception = assertThrows(AddressException.class, () -> this.address = new Address("null", "377", "93200200", null));

        assertNotNull(exception);
        assertEquals(AddressException.ERROR.getMessage(Address.CITY_NAME_REQUIRED), exception.getMessage());
    }

    @Test
    void shouldNotCreateAddressWithEmptyCity() {
        AddressException exception = assertThrows(AddressException.class, () -> this.address = new Address("Rua", "377", "93200200", ""));

        assertNotNull(exception);
        assertEquals(AddressException.ERROR.getMessage(Address.CITY_NAME_REQUIRED), exception.getMessage());
    }

    @Test
    void shouldContainCorrectAttributesWhenAddressConvertedToString() {
        String addressRepresentation = this.address.toString();

        assertContains("Rua", addressRepresentation);
        assertContains("377", addressRepresentation);
        assertContains("93200200", addressRepresentation);
        assertContains("Cidade", addressRepresentation);
    }

    private void assertContains(String expected, String actual) {
        assertTrue(actual.contains(expected), String.format("A string esperada não contém: %s", expected));
    }

}
