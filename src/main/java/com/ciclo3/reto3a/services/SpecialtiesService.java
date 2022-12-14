package com.ciclo3.reto3a.services;


import com.ciclo3.reto3a.entities.Specialties;
import com.ciclo3.reto3a.repositories.SpecialtiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtiesService {

    @Autowired
    private SpecialtiesRepository specialtiesRepository;

    public List<Specialties> getAll(){

        return specialtiesRepository.getAll();
    }

    public Optional<Specialties> getSpecialty(int id){

        return specialtiesRepository.getSpecialty(id);
    }

    public Specialties save(Specialties sp){

        if(sp.getId()==null){

            return specialtiesRepository.save(sp);
        }else{

            Optional<Specialties> sp2= specialtiesRepository.getSpecialty(sp.getId());

            if(sp2.isPresent()){
                return sp;
            }else{
                return specialtiesRepository.save(sp);
            }
        }
    }

    public Specialties update(Specialties sp){

        if(sp.getId()!=null){

            Optional<Specialties> sp2 = specialtiesRepository.getSpecialty(sp.getId());//Traer elemento BD con id de sp

            if(sp2.isPresent()){

                if(sp.getName()!=null){

                    sp2.get().setName(sp.getName());

                }
                if(sp.getDescription()!=null){

                    sp2.get().setDescription(sp.getDescription());

                }
                if(sp.getDoctors()!=null){

                    sp2.get().setDoctors(sp.getDoctors());

                }

                specialtiesRepository.save(sp2.get());
                return sp2.get();

            }else{
                return sp;
            }

        }
        return sp;
    }

    public boolean delete(Specialties sp){

        boolean flag = false;

        Optional<Specialties> sp2 = specialtiesRepository.getSpecialty(sp.getId());

        if(sp2.isPresent()){

            specialtiesRepository.delete(sp2.get());
            flag = true;
        }

        return flag;

    }




}
