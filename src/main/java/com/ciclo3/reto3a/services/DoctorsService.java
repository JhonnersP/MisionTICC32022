package com.ciclo3.reto3a.services;


import com.ciclo3.reto3a.entities.Doctors;
import com.ciclo3.reto3a.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsRepository doctorsRepository;

    public List<Doctors> getAll(){

        return doctorsRepository.getAll();
    }

    public Optional<Doctors> getDoctor(int id){

        return doctorsRepository.getDoctor(id);

    }

    public Doctors save(Doctors doc){

        if(doc.getId()==null){

            return doctorsRepository.save(doc);
        }else{

            Optional<Doctors> dc = doctorsRepository.getDoctor(doc.getId());

            if(dc.isPresent()){

                return doc;
            }else {

                return doctorsRepository.save(doc);

            }
        }
    }

    public Doctors update(Doctors doc){

        if(doc.getId()!=null){

            Optional<Doctors> dc= doctorsRepository.getDoctor(doc.getId());//Se obtiene base de datos

            if(dc.isPresent()){

                if(doc.getName()!=null){

                    dc.get().setName(doc.getName());
                }
                if(doc.getDepartment()!=null){

                    dc.get().setDepartment(doc.getDepartment());

                }
                if(doc.getDescription()!=null){

                    dc.get().setDescription(doc.getDescription());

                }
                if(doc.getReservations()!=null){

                    dc.get().setReservations(doc.getReservations());

                }
                if(doc.getMessages()!=null){

                    dc.get().setMessages(doc.getMessages());

                }
                if(doc.getSpecialty()!=null){

                    dc.get().setSpecialty(doc.getSpecialty());

                }
                if(doc.getYear()!=null){

                    dc.get().setYear(doc.getYear());

                }
                doctorsRepository.save(dc.get());
                return dc.get();
            }else{
                return doc;
            }
        }
        return doc;
    }

    public boolean delete(int id){

        boolean flag = false;
        Optional<Doctors> dc = doctorsRepository.getDoctor(id);

        if(dc.isPresent()){

            doctorsRepository.delete(dc.get());
            flag = true;
        }

        return flag;
    }




}
