package com.ciclo3.reto5.services;


import com.ciclo3.reto5.entities.Reservations;
import com.ciclo3.reto5.entities.custom.CountClient;
import com.ciclo3.reto5.entities.custom.StatusAmount;
import com.ciclo3.reto5.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<Reservations> getAll(){

        return reservationsRepository.getAll();
    }

    public Optional<Reservations> getReservation(int id){

        return reservationsRepository.getReservation(id);
    }

    public Reservations save(Reservations r){

        if(r.getIdReservation()==null){

            return reservationsRepository.save(r);
        }else{

            Optional<Reservations> r2= reservationsRepository.getReservation(r.getIdReservation());

            if(r2.isPresent()){
                return r;
            }else{
                return reservationsRepository.save(r);
            }
        }
    }

    public Reservations update(Reservations r){

        if(r.getIdReservation()!=null){

            Optional<Reservations> r2 = reservationsRepository.getReservation(r.getIdReservation());//Traer elemento BD con id de sp

            if(r2.isPresent()){

                if(r.getStartDate()!=null){

                    r2.get().setStartDate(r.getStartDate());

                }
                if(r.getDevolutionDate()!=null){

                    r2.get().setDevolutionDate(r.getDevolutionDate());

                }
                if(r.getDoctor()!=null){

                    r2.get().setDoctor(r.getDoctor());

                }
                if(r.getClient()!=null){

                    r2.get().setClient(r.getClient());
                }

                reservationsRepository.save(r2.get());
                return r2.get();

            }else{
                return r;
            }

        }
        return r;
    }

    public boolean delete(int reservationId){

        Boolean del = getReservation(reservationId).map(reservations -> {
            reservationsRepository.delete(reservations);
            return true;
        }).orElse(false);
        return del;



    }

    public List<CountClient> getTopClients(){

        return reservationsRepository.getTopClients();
    }

    public List<Reservations> getReservationsPeriod(String dateA, String dateB){

        SimpleDateFormat parser= new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a= parser.parse(dateA);
            b= parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();
        }

        if(a.before(b)){
            return reservationsRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }
    }

    public StatusAmount getReservationsStatusReport(){

        List<Reservations>completed=reservationsRepository.getReservationByStatus("completed");
        List<Reservations>cancelled=reservationsRepository.getReservationByStatus("cancelled");

        return  new StatusAmount(completed.size(),cancelled.size());
    }




}
