package ksftaxispringback.service.impl;

import ksftaxispringback.entity.Address;
import ksftaxispringback.entity.AddressType;
import ksftaxispringback.entity.dto.AddressDto;
import ksftaxispringback.repository.AddressDao;
import ksftaxispringback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao;

    @Override
    public Address save(AddressDto addressDto) {
      Address address=new Address(addressDto.getStreetNumber(), addressDto.getStreet(),addressDto.getPostCode(),
              addressDto.getCity(), addressDto.getLatitude(), addressDto.getLongitude(), addressDto.getAddressType());
        return addressDao.save(address);
    }



    @Autowired
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
