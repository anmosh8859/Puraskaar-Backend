package com.puraskar.website.Puraskaar.Data.Management.controller;

import com.puraskar.website.Puraskaar.Data.Management.entity.RegistrationForm;
import com.puraskar.website.Puraskaar.Data.Management.services.RegistrationFormServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("registration-form")
public class RegistrationFormController {

    private RegistrationFormServices services;

    public RegistrationFormController(RegistrationFormServices services) {
        this.services = services;
    }

    @GetMapping("/forms")
    public List<RegistrationForm> retrieveAllRegistrationForms(){
        return services.retrieveAllRegistrationForms();
    }

    @GetMapping("/forms/{id}")
    public RegistrationForm retriveRegistrationForm(@PathVariable String id){
        try {
            RegistrationForm form = services.findRegistrationFormById(id);
            return form;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/forms")
    public ResponseEntity saveRegistrationForm(@RequestBody RegistrationForm registrationForm){
        RegistrationForm savedForm = services.saveRegistrationForm(registrationForm);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/forms/{id}")
    public RegistrationForm updateRegistrationForm(@RequestBody RegistrationForm registrationForm, @PathVariable String id){
        return services.updateRegistrationForm(registrationForm,id);
    }

    @DeleteMapping("/forms/{id}")
    public void deleteRegistrationForm(@PathVariable String id){
        services.deleteById(id);
    }
}
