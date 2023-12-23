package com.puraskar.website.Puraskaar.Data.Management.services;

import com.puraskar.website.Puraskaar.Data.Management.entity.RegistrationForm;
import com.puraskar.website.Puraskaar.Data.Management.repository.RegistrationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationFormServices {

    RegistrationFormRepository registrationFormRepository;

    public RegistrationFormServices(RegistrationFormRepository registrationFormRepository) {
        this.registrationFormRepository = registrationFormRepository;
    }

    public RegistrationForm saveRegistrationForm(RegistrationForm form){
        return registrationFormRepository.save(form);
    }

    public List<RegistrationForm> retrieveAllRegistrationForms(){
        return registrationFormRepository.findAll();
    }

    public RegistrationForm findRegistrationFormById(String id){
        return registrationFormRepository.findById(id).orElse(null);
    }

    public RegistrationForm updateRegistrationForm(RegistrationForm form, String id){
        this.deleteById(id);
        return registrationFormRepository.save(form);
    }

    public void deleteById(String id){
        RegistrationForm registrationForm = registrationFormRepository.findById(id).orElse(null);
        if(registrationForm!=null) registrationFormRepository.deleteById(id);
    }
}