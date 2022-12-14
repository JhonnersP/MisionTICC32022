package com.ciclo3.reto3a.repositories;

import com.ciclo3.reto3a.entities.Admin;
import com.ciclo3.reto3a.repositories.crudRepositories.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){

        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){

        return adminCrudRepository.findById(id);
    }

    public Admin save(Admin adm){

        return adminCrudRepository.save(adm);
    }

    public void delete(Admin adm){

        adminCrudRepository.delete(adm);
    }
}
