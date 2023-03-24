package ksftaxispringback.service;

import ksftaxispringback.entity.Address;
import ksftaxispringback.entity.AddressType;
import ksftaxispringback.entity.dto.AddressDto;

public interface AddressService {

    Address save(AddressDto adresseDto);
}
