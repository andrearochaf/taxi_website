package ksftaxispringback.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ClientMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String transmitterEmail;
    private String message;
    private LocalDate receivedDate;
    private LocalDate replyDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Client client;

    public ClientMessage() {
    }

    //constructor for test
    public ClientMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public ClientMessage(String name, String transmitterEmail, String message, LocalDate receivedDate, LocalDate replyDate) {
        this.name= name;
        this.transmitterEmail = transmitterEmail;
        this.message = message;
        this.receivedDate = receivedDate;
        this.replyDate = replyDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTransmitterEmail() {
        return transmitterEmail;
    }
    public void setTransmitterEmail(String transmitterEmail) {
        this.transmitterEmail = transmitterEmail;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDate getReceivedDate() {
        return receivedDate;
    }
    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }
    public LocalDate getReplyDate() {
        return replyDate;
    }
    public void setReplyDate(LocalDate replyDate) {
        this.replyDate = replyDate;
    }
}
