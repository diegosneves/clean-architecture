package diegosneves.github.cleanarchitecture.domain.customer.entity;


import diegosneves.github.cleanarchitecture.domain.customer.value.Address;
import diegosneves.github.cleanarchitecture.exception.CustomerException;

import static java.util.Objects.isNull;

public class Customer implements CustomerContract {

    public static final String NAME_REQUIRED_ERROR = "Para o registro correto, um nome válido é necessário";
    public static final String ID_REQUIRED_ERROR_MESSAGE = "Um ID válido precisa ser fornecido";
    public static final String ADDRESS_REQUIRED_ERROR_MESSAGE = "Você deve registrar um endereço para ativar o cliente.";

    private final String id;
    private String name;
    private Address address;
    private Boolean active = Boolean.FALSE;
    private Integer rewardPoints = 0;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.validate();
    }

    private void validate() {
        this.validateField(this.id, ID_REQUIRED_ERROR_MESSAGE);
        this.validateField(this.name, NAME_REQUIRED_ERROR);
    }

    private void validateField(String field, String errorMessage) throws CustomerException {
        if (field == null || field.isBlank()) {
            throw new CustomerException(errorMessage);
        }
    }

    public void changeName(String name) {
        this.name = name;
        this.validate();
    }

    public void activateCustomer() throws CustomerException {
        if (isNull(this.address)) {
            throw new CustomerException(ADDRESS_REQUIRED_ERROR_MESSAGE);
        }
        this.active = Boolean.TRUE;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public Boolean getActive() {
        return this.active;
    }

    @Override
    public Integer getRewardPoints() {
        return this.rewardPoints;
    }

    public void addRewardPoints(Integer points) {
        this.rewardPoints += points;
    }

    public void addAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", active=" + active +
                ", rewardPoints=" + rewardPoints +
                '}';
    }
}
