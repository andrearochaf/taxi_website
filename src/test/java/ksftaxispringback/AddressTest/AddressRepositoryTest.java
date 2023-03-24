package ksftaxispringback.AddressTest;

import ksftaxispringback.entity.Address;
import ksftaxispringback.entity.dto.AddressDto;
import ksftaxispringback.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AddressRepositoryTest {

    AddressService addressService;

    @Test
    public void shouldSaveAddressSuccessfully() {
        AddressDto address = new AddressDto();
        address.setCity("Paris");
       Address addressToSave = addressService.save(address);

        assertNotNull(addressToSave);
        assertEquals(addressToSave.getCity(), address.getCity());
    }


    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }
}
