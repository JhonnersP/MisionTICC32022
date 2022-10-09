package com.ciclo3.reto3a.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Date startDate;
    private Date devolutionDate;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    @JsonIgnoreProperties("reservations")
    private Doctors doctor;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties("reservations")
    private Clients client;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
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
