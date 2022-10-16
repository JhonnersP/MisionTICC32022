package com.ciclo3.reto4.controllers;

import com.ciclo3.reto4.entities.Messages;
import com.ciclo3.reto4.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    @GetMapping("/all")
    public List<Messages> getAll(){
        return messagesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Messages> get(@PathVariable("id") int Id) {
        return messagesService.getMessage(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save(@RequestBody Messages m){

        return messagesService.save(m);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages update(@RequestBody Messages m){
        return messagesService.update(m);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int messageId){

        return messagesService.delete(messageId);
    }


}
