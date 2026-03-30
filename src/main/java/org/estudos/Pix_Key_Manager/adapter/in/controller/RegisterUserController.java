package org.estudos.Pix_Key_Manager.adapter.in.controller;

import jakarta.validation.Valid;
import org.estudos.Pix_Key_Manager.adapter.in.dtos.mappers.RegisterUserMapper;
import org.estudos.Pix_Key_Manager.adapter.in.dtos.registerUser.RegisterUserRequestDTO;
import org.estudos.Pix_Key_Manager.application.ports.in.RegisterUserInPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class RegisterUserController {

    private final RegisterUserInPort registerUserInPort;

    public RegisterUserController(RegisterUserInPort registerUserInPort) {
        this.registerUserInPort = registerUserInPort;
    }

    @PostMapping(value = "/register-user")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterUserRequestDTO userDTO) {

        registerUserInPort.execute(RegisterUserMapper.toDomain(userDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body("User successfully registered.");
    }



}
