package com.ciclo3.reto3a.controllers;

import com.ciclo3.reto3a.entities.Clients;
import com.ciclo3.reto3a.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping("/all")
    public List<Clients> getAll(){
        return clientsService.getAll();
    }

    @PostMapping("/save")
    public Clients save(@RequestBody Clients cl){

        return clientsService.save(cl);
    }


}
