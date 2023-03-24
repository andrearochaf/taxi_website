package ksftaxispringback.service.impl;

import ksftaxispringback.entity.ClientMessage;
import ksftaxispringback.entity.dto.ClientMessageDto;
import ksftaxispringback.repository.ClientMessageDao;
import ksftaxispringback.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class ContactServiceImpl implements ContactService {

    private ClientMessageDao clientMessageDao;

    @Override
    public List<ClientMessage> findAll() {
        return clientMessageDao.findAll();
    }

    @Override
    public ClientMessage save(ClientMessageDto clientMessageDto) {
        clientMessageDto.setReceivedDate(LocalDate.now());
        ClientMessage clientMessage=new ClientMessage(clientMessageDto.getName(), clientMessageDto.getTransmitterEmail(), clientMessageDto.getMessage(),
                clientMessageDto.getReceivedDate(), clientMessageDto.getReplyDate());
        return clientMessageDao.save(clientMessage);
    }

    @Autowired
    public void setClientMessageDao(ClientMessageDao clientMessageDao) {
        this.clientMessageDao = clientMessageDao;
    }
}
