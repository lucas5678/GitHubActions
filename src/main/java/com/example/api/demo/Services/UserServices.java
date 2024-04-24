package com.example.api.demo.Services;

import java.util.List;

import com.example.api.demo.Modelo.ModeloUser;

public interface UserServices {
    //contratos de usuarios.
    List<ModeloUser> findAll();

    ModeloUser findById(int id);

    ModeloUser save(ModeloUser objUsuario);
}
