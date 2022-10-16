package com.ciclo3.reto4.services;


import com.ciclo3.reto4.entities.Admin;
import com.ciclo3.reto4.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){

        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){

        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin adm){

        if(adm.getIdAdmin()==null){

            return adminRepository.save(adm);

        }else{

            Optional<Admin> adm2= adminRepository.getAdmin(adm.getIdAdmin());

            if(adm2.isPresent()){
                return adm;
            }else{
                return adminRepository.save(adm);
            }
        }
    }

    public Admin update(Admin adm){

        if(adm.getIdAdmin()!=null){

            Optional<Admin> adm2 = adminRepository.getAdmin(adm.getIdAdmin());//Traer elemento BD con id de sp

            if(adm2.isPresent()){

                if(adm.getName()!=null){

                    adm2.get().setName(adm.getName());

                }
                if(adm.getEmail()!=null){

                    adm2.get().setEmail(adm.getEmail());

                }
                if(adm.getPassword()!=null){

                    adm2.get().setPassword(adm.getPassword());

                }


                adminRepository.save(adm2.get());
                return adm2.get();

            }else{
                return adm;
            }

        }
        return adm;
    }

    public boolean delete(int admId){

        Boolean del = getAdmin(admId).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return del;

    }




}
