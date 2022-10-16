package com.ciclo3.reto4.services;


import com.ciclo3.reto4.entities.Clients;
import com.ciclo3.reto4.repositories.ClientsRepository;
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

        if(cl.getIdClient()==null){

            return clientsRepository.save(cl);
        }else{

            Optional<Clients> cl2= clientsRepository.getClient(cl.getIdClient());

            if(cl2.isPresent()){
                return cl;
            }else{
                return clientsRepository.save(cl);
            }
        }
    }

    public Clients update(Clients cl){

        if(cl.getIdClient()!=null){

            Optional<Clients> cl2 = clientsRepository.getClient(cl.getIdClient());//Traer elemento BD con id de sp

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
                if(cl.getMessages()!=null){
                    cl2.get().setMessages(cl.getMessages());
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

    public boolean delete(int clientId){

        Boolean del = getClient(clientId).map(clients -> {
            clientsRepository.delete(clients);
            return true;
        }).orElse(false);
        return del;

    }




}
