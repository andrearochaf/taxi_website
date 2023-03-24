package ksftaxispringback.service;

import ksftaxispringback.entity.Address;
import ksftaxispringback.entity.ClientMessage;
import ksftaxispringback.entity.dto.AddressDto;
import ksftaxispringback.entity.dto.ClientMessageDto;

import java.util.List;


public interface ContactService {

    /**
     * @return all messages from people (client or not)
     */
    List<ClientMessage> findAll();
    ClientMessage save(ClientMessageDto clientMessageDto);

}
