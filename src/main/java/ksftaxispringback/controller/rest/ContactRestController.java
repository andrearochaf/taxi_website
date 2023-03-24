package ksftaxispringback.controller.rest;

import ksftaxispringback.entity.Address;
import ksftaxispringback.entity.ClientMessage;
import ksftaxispringback.entity.CourseType;
import ksftaxispringback.entity.dto.AddressDto;
import ksftaxispringback.entity.dto.ClientMessageDto;
import ksftaxispringback.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactRestController {


    private ContactService contactService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/messages")
    public List<ClientMessage> findAll() {
        return contactService.findAll();
    }

    @PostMapping("/message")
    public ClientMessage saveMessage(@RequestBody ClientMessageDto clientMessageDto){
        return contactService.save(clientMessageDto);
    }


    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }
}