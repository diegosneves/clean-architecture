package diegosneves.github.cleanarchitecture.domain.customer.entity;

import diegosneves.github.cleanarchitecture.domain.customer.value.Address;

public interface CustomerContract {

    String getId();

    String getName();

    Address getAddress();

    Boolean getActive();

    Integer getRewardPoints();

}
