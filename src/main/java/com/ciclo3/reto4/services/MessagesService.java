package com.ciclo3.reto4.services;


import com.ciclo3.reto4.entities.Messages;
import com.ciclo3.reto4.repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    public List<Messages> getAll(){

        return messagesRepository.getAll();
    }

    public Optional<Messages> getMessage(int id){

        return messagesRepository.getMessage(id);
    }

    public Messages save(Messages m){

        if(m.getIdMessage()==null){

            return messagesRepository.save(m);
        }else{

            Optional<Messages> sp2= messagesRepository.getMessage(m.getIdMessage());

            if(sp2.isPresent()){
                return m;
            }else{
                return messagesRepository.save(m);
            }
        }
    }

    public Messages update(Messages m){

        if(m.getIdMessage()!=null){

            Optional<Messages> m2 = messagesRepository.getMessage(m.getIdMessage());//Traer elemento BD con id de sp

            if(m2.isPresent()){

                if(m.getMessageText()!=null){

                    m2.get().setMessageText(m.getMessageText());

                }
                if(m.getClient()!=null){

                    m2.get().setClient(m.getClient());

                }
                if(m.getDoctor()!=null){

                    m2.get().setDoctor(m.getDoctor());

                }

                messagesRepository.save(m2.get());
                return m2.get();

            }else{
                return m;
            }

        }
        return m;
    }

    public boolean delete(Messages m){

        boolean flag = false;

        Optional<Messages> m2 = messagesRepository.getMessage(m.getIdMessage());

        if(m2.isPresent()){

            messagesRepository.delete(m2.get());
            flag = true;
        }

        return flag;

    }




}
