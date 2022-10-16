package com.ciclo3.reto5.controllers;

import com.ciclo3.reto5.entities.Clients;
import com.ciclo3.reto5.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping("/all")
    public List<Clients> getAll(){
        return clientsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clients> get(@PathVariable("id") int Id) {
        return clientsService.getClient(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clients save(@RequestBody Clients cl){

        return clientsService.save(cl);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clients update(@RequestBody Clients clientId){

        return clientsService.update(clientId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int clientId){

        return clientsService.delete(clientId);
    }


}
