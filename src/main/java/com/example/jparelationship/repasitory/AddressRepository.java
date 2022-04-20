package com.example.jparelationship.repasitory;

import com.example.jparelationship.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
