package com.ciclo3.reto3a.controllers;

import com.ciclo3.reto3a.entities.Messages;
import com.ciclo3.reto3a.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Messages> getAll(){
        return messagesService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save(@RequestBody Messages m){

        return messagesService.save(m);
    }


}
