package com.ciclo3.reto5.entities.custom;

import com.ciclo3.reto5.entities.Clients;

public class CountClient {

    private Long total;
    private Clients client;

    public CountClient(Long total, Clients client){

        this.total = total;
        this.client = client;

    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
}
