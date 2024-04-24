package com.example.api.demo.Services.impl;

import java.util.Optional;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import com.example.api.demo.Modelo.ModeloUser;
import com.example.api.demo.Repository.usuariosRepo;
import com.example.api.demo.Services.UserServices;
import com.example.api.demo.Services.ExceptionSupplier;
import com.example.api.demo.Services.Exceptions.ObjectBadResquest;
import com.example.api.demo.Services.Exceptions.ObjectNotFoudExceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;


@Service
public class UserImpl implements UserServices {
    //metodos que devem ser implementados.
    @Autowired
    usuariosRepo userRepo;

    @Autowired
    Validator validator;

    @Override
    public java.util.List<ModeloUser> findAll() {
        return (java.util.List<ModeloUser>) userRepo.findAll();
    }

    @Override
    public ModeloUser findById(int id) {
        Optional<ModeloUser> obj = userRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoudExceptions("Usuário não encontrado com o ID: " + id));
    }

    @Override
    public ModeloUser save(ModeloUser objUsuario) {
        Set<ConstraintViolation<ModeloUser>> violations = validator.validate(objUsuario);
        Optional<ModeloUser> obj = Optional.ofNullable(null);
        if(!violations.isEmpty()){
            return obj.orElseThrow(() -> new ObjectBadResquest("Preencha todos os campos"));
        }   
        return null;
    }   

}
