package com.example.DislinktXWS.controller;

import com.example.DislinktXWS.DTO.RegistrationDTO;
import com.example.DislinktXWS.model.User;
import com.example.DislinktXWS.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class RegistrationController
{
    @Autowired
    RegistrationService registrationService;

    @PostMapping(value = "/api/registration", consumes = MediaType.APPLICATION_JSON_VALUE,     // tip podataka koje metoda može da primi
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registration(@RequestBody RegistrationDTO registration_DTO)
    {

        //Validacija username
        if(registration_DTO.getUsername().isEmpty() || registration_DTO.getPassword().isEmpty())
        {
            return  new ResponseEntity<>("Neispravno uneti podaci!", HttpStatus.BAD_REQUEST);
        }
        else if(registrationService.getByUsername(registration_DTO.getUsername()) != null)
        {
            return  new ResponseEntity<>("Username already exists!", HttpStatus.BAD_REQUEST);
        }


        User user = new User();
        user.setId(registration_DTO.getId());
        user.setFirstName(registration_DTO.getFirstName());
        user.setLastName(registration_DTO.getLastName());
        user.setEmail(registration_DTO.getEmail());
        user.setUsername(registration_DTO.getUsername());
        user.setPassword(registration_DTO.getPassword());
        user.setDateOfBirth(registration_DTO.getDateOfBirth());


        registrationService.registration(user);
        System.out.println("Succesfully registration for new user! ");
        return ResponseEntity.ok("Registration Succesfully!");

    }
}
