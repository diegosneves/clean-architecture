package diegosneves.github.cleanarchitecture.domain.customer.entity;

import diegosneves.github.cleanarchitecture.domain.customer.value.Address;
import diegosneves.github.cleanarchitecture.exception.CustomerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class CustomerTest {

    private Customer customer;

    private Address address;

    @BeforeEach
    void setUp() {
        this.customer = new Customer("ID001", "Customer Name");
        this.address = new Address("Rua", "377", "93200200", "Cidade");
    }

    @Test
    void shouldCreateCustomer() {

        this.customer = new Customer("id", "Name");

        assertNotNull(this.customer);
        assertEquals("id", this.customer.getId());
        assertEquals("Name", this.customer.getName());
        assertNull(this.customer.getAddress());
        assertFalse(this.customer.getActive());
    }

    @Test
    void shouldThrowExceptionWhenCustomerIdIsNull() {

        CustomerException exception = assertThrows(CustomerException.class, () -> this.customer = new Customer(null, "Name"));

        assertNotNull(exception);
        assertEquals(CustomerException.ERROR.getMessage(Customer.ID_REQUIRED_ERROR_MESSAGE), exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCustomerIdIsBlank() {

        CustomerException exception = assertThrows(CustomerException.class, () -> this.customer = new Customer("  ", "Name"));

        assertNotNull(exception);
        assertEquals(CustomerException.ERROR.getMessage(Customer.ID_REQUIRED_ERROR_MESSAGE), exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCustomerNameIsNull() {

        CustomerException exception = assertThrows(CustomerException.class, () -> this.customer = new Customer("001", null));

        assertNotNull(exception);
        assertEquals(CustomerException.ERROR.getMessage(Customer.NAME_REQUIRED_ERROR), exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCustomerNameIsBlank() {

        CustomerException exception = assertThrows(CustomerException.class, () -> this.customer = new Customer("001", ""));

        assertNotNull(exception);
        assertEquals(CustomerException.ERROR.getMessage(Customer.NAME_REQUIRED_ERROR), exception.getMessage());
    }

    @Test
    void shouldChangeCustomerNameSuccessfully() {
        String newName = "New Name";

        this.customer.changeName(newName);

        assertEquals(newName, this.customer.getName());
        assertEquals("ID001", this.customer.getId());
    }

    @Test
    void shouldThrowCustomerExceptionWhenChangingNameToEmpty() {
        String newName = "";

        CustomerException exception = assertThrows(CustomerException.class, () -> this.customer.changeName(newName));

        assertNotNull(exception);
        assertEquals(CustomerException.ERROR.getMessage(Customer.NAME_REQUIRED_ERROR), exception.getMessage());
    }

    @Test
    void shouldThrowCustomerExceptionWhenChangingNameToNull() {

        CustomerException exception = assertThrows(CustomerException.class, () -> this.customer.changeName(null));

        assertNotNull(exception);
        assertEquals(CustomerException.ERROR.getMessage(Customer.NAME_REQUIRED_ERROR), exception.getMessage());
    }

    @Test
    void shouldAddAddressToCustomer() {
        Address actualAddress = this.customer.getAddress();

        this.customer.addAddress(this.address);

        assertNull(actualAddress);
        assertNotNull(this.customer.getAddress());
        assertEquals(this.address, this.customer.getAddress());
    }

    @Test
    void shouldActivateCustomerSuccessfully() {
        this.customer.addAddress(this.address);

        this.customer.activateCustomer();

        assertTrue(this.customer.getActive());
        assertNotNull(this.customer.getAddress());
    }

    @Test
    void shouldThrowCustomerExceptionWhenActivatingWithoutAddress() {

        CustomerException exception = assertThrows(CustomerException.class, () -> this.customer.activateCustomer());

        assertNotNull(exception);
        assertEquals(CustomerException.ERROR.getMessage(Customer.ADDRESS_REQUIRED_ERROR_MESSAGE), exception.getMessage());
    }

    @Test
    void shouldReturnZeroRewardPointsForNewCustomer() {
        assertEquals(0, this.customer.getRewardPoints());
    }

    @Test
    void shouldAccumulateRewardPointsWhenAdded() {
        this.customer.addRewardPoints(5);
        this.customer.addRewardPoints(10);

        assertEquals(15, this.customer.getRewardPoints());
    }

    @Test
    void shouldContainCorrectAttributesWhenCustomerConvertedToString() {
        String customerRepresentation = this.customer.toString();

        System.out.println(customerRepresentation);
        assertContains("ID001", customerRepresentation);
        assertContains("Customer Name", customerRepresentation);
        assertContains("null", customerRepresentation);
        assertContains("false", customerRepresentation);
        assertContains("0", customerRepresentation);
    }

    private void assertContains(String expected, String actual) {
        assertTrue(actual.contains(expected), String.format("A string esperada não contém: %s", expected));
    }

}
