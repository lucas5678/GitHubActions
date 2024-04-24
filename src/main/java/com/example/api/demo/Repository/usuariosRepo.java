package com.example.api.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.api.demo.Modelo.ModeloUser;
import java.util.Optional;


public interface usuariosRepo extends CrudRepository<ModeloUser,Integer>{
    
    Optional<ModeloUser> findById(int id);
}
