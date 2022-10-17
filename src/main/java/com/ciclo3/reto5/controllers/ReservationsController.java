package com.ciclo3.reto5.controllers;

import com.ciclo3.reto5.entities.Reservations;
import com.ciclo3.reto5.entities.custom.CountClient;
import com.ciclo3.reto5.entities.custom.StatusAmount;
import com.ciclo3.reto5.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @GetMapping("/all")
    public List<Reservations> getAll(){
        return reservationsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservations> get(@PathVariable("id") int Id) {
        return reservationsService.getReservation(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations save(@RequestBody Reservations r){

        return reservationsService.save(r);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations update(@RequestBody Reservations r){

        return reservationsService.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){

        return reservationsService.delete(reservationId);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportCLient(){

        return reservationsService.getTopClients();
    }

    @GetMapping("report-dates/{dateOne}/{dateTwo}")
    public Integer getReservationReportDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){

        return reservationsService.getReservationsPeriod(dateOne,dateTwo).size();
    }

    @GetMapping("/report-status")
        public StatusAmount getReservationsStatusReport(){
            return reservationsService.getReservationsStatusReport();
        }
    }


