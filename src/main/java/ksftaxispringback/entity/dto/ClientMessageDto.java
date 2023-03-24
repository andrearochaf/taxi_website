package ksftaxispringback.entity.dto;

import ksftaxispringback.entity.Client;

import java.time.LocalDate;

public class ClientMessageDto {
    private String name;
    private String transmitterEmail;
    private String message;
    private LocalDate receivedDate;
    private LocalDate replyDate;
    private Client client;

    public ClientMessageDto() {
    }

    public String getName() {
        return name;
    }
    public String getTransmitterEmail() {
        return transmitterEmail;
    }
    public String getMessage() {
        return message;
    }
    public LocalDate getReceivedDate() {
        return receivedDate;
    }
    public LocalDate getReplyDate() {
        return replyDate;
    }
    public Client getClient() {
        return client;
    }

    public void setReplyDate(LocalDate replyDate) {
        this.replyDate = replyDate;
    }
    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTransmitterEmail(String transmitterEmail) {
        this.transmitterEmail = transmitterEmail;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
