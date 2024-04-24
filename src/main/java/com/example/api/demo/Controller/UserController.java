package com.example.api.demo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.Modelo.ModeloUser;
import com.example.api.demo.Modelo.DTO.UserDto;
import com.example.api.demo.Services.impl.UserImpl;

@RestController
public class UserController {
    //controller usuario.
    @Autowired
    UserImpl implemento;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/usuariosAll")
    private ResponseEntity<List<UserDto>> UsuariosAll(){
        return ResponseEntity.ok().body(implemento.findAll()
            .stream().map(x -> mapper.map(x, UserDto.class)).collect(Collectors.toList())
        );
    }

    @PostMapping("/usuario")
    private ResponseEntity<UserDto> Usuario(@RequestBody ModeloUser usuario){
        return ResponseEntity.ok().body(mapper.map(implemento.findById(usuario.getId()), UserDto.class));
    }

    @PostMapping("/usuario-cadastro")
    private ResponseEntity<ModeloUser> CriarUsuario(@RequestBody UserDto objUser){
        
        return ResponseEntity.ok().body(implemento.save(mapper.map(objUser, ModeloUser.class)));
    }
}
