package com.ciclo3.reto3a.entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "tblmessages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMessage;
    private String MessageText;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Doctors doctor;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Clients client;

    public Integer getIdMessage() {
        return IdMessage;
    }

    public void setIdMessage(Integer idMessage) {
        IdMessage = idMessage;
    }

    public String getMessageText() {
        return MessageText;
    }

    public void setMessageText(String messageText) {
        MessageText = messageText;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
}
