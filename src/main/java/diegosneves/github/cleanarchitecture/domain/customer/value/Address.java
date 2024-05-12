package diegosneves.github.cleanarchitecture.domain.customer.value;

import diegosneves.github.cleanarchitecture.exception.AddressException;
import lombok.Getter;

@Getter
public class Address {

    public static final String STREET_REQUIRED = "O nome da rua deve ser informado";
    public static final String RESIDENCE_NUMBER_REQUIRED = "Um numero de residencia deve ser informado";
    public static final String ZIP_CODE_REQUIRED = "O CEP deve ser informado";
    public static final String CITY_NAME_REQUIRED = "O nome da cidade deve ser informado";

    private final String street;
    private final String number;
    private final String zipCode;
    private final String city;

    public Address(String street, String number, String zipCode, String city) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.validate();
    }

    private void validate() {
        this.validateField(this.street, STREET_REQUIRED);
        this.validateField(this.number, RESIDENCE_NUMBER_REQUIRED);
        this.validateField(this.zipCode, ZIP_CODE_REQUIRED);
        this.validateField(this.city, CITY_NAME_REQUIRED);
    }

    private void validateField(String field, String errorMessage) {
        if (field == null || field.isBlank()) {
            throw new AddressException(errorMessage);
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
