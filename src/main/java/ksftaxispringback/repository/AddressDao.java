package ksftaxispringback.repository;

import ksftaxispringback.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Long> {

    Address findById(long id);
}
