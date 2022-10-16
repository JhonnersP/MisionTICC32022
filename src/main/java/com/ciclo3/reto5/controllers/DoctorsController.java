package com.ciclo3.reto5.controllers;

import com.ciclo3.reto5.entities.Doctors;
import com.ciclo3.reto5.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @GetMapping("/all")
    public List<Doctors> getAll(){

        return doctorsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctors> get(@PathVariable("id") int Id) {
        return doctorsService.getDoctor(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctors save(@RequestBody Doctors doc){

        return doctorsService.save(doc);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctors update(@RequestBody Doctors doc){

        return doctorsService.update(doc);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int doctorId){

        return doctorsService.delete(doctorId);
    }
}
