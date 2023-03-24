package ksftaxispringback.Contact;

import ksftaxispringback.entity.ClientMessage;
import ksftaxispringback.entity.Person;
import ksftaxispringback.entity.dto.ClientMessageDto;
import ksftaxispringback.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ContactTest {

    private ContactService contactService;
    private ClientMessageDto clientMessageDto= new ClientMessageDto();
    private List<ClientMessage> clientMessageList= new ArrayList<>();


    @BeforeEach
    public void setup(){
        clientMessageDto.setReceivedDate(LocalDate.now());
        clientMessageDto.setMessage("hi");
        clientMessageDto.setName("Message pour dire bonjour");
    }


    @Test
    public void shouldSaveMessageFromClient(){
        ClientMessage messageToSaved = contactService.save(clientMessageDto);
       assertNotNull(messageToSaved);
       assertEquals("hi", messageToSaved.getMessage());

    }

    @Test
    public void shouldfindMessages(){
        clientMessageList = contactService.findAll();
       assertNotNull(clientMessageList);
    }


    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }
}
