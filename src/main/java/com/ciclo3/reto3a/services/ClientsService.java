package com.ciclo3.reto3a.services;


import com.ciclo3.reto3a.entities.Clients;
import com.ciclo3.reto3a.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    public List<Clients> getAll(){

        return clientsRepository.getAll();
    }

    public Optional<Clients> getClient(int id){

        return clientsRepository.getClient(id);
    }

    public Clients save(Clients cl){

        if(cl.getId()==null){

            return clientsRepository.save(cl);
        }else{

            Optional<Clients> cl2= clientsRepository.getClient(cl.getId());

            if(cl2.isPresent()){
                return cl;
            }else{
                return clientsRepository.save(cl);
            }
        }
    }

    public Clients update(Clients cl){

        if(cl.getId()!=null){

            Optional<Clients> cl2 = clientsRepository.getClient(cl.getId());//Traer elemento BD con id de sp

            if(cl2.isPresent()){

                if(cl.getName()!=null){

                    cl2.get().setName(cl.getName());

                }
                if(cl.getEmail()!=null){

                    cl2.get().setEmail(cl.getEmail());

                }
                if(cl.getPassword()!=null){

                    cl2.get().setPassword(cl.getPassword());

                }
                if(cl.getAge()!=null){
                    cl2.get().setAge(cl.getAge());
                }
                if(cl.getMessage()!=null){
                    cl2.get().setMessage(cl.getMessage());
                }
                if(cl.getReservations()!=null){
                    cl2.get().setReservations(cl.getReservations());
                }

                clientsRepository.save(cl2.get());
                return cl2.get();

            }else{
                return cl;
            }

        }
        return cl;
    }

    public boolean delete(Clients cl){

        boolean flag = false;

        Optional<Clients> cl2 = clientsRepository.getClient(cl.getId());

        if(cl2.isPresent()){

            clientsRepository.delete(cl2.get());
            flag = true;
        }

        return flag;

    }




}
