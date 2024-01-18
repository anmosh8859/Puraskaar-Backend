package com.puraskaar.puraskaar.services.volunteer;

import org.springframework.beans.factory.annotation.Autowired;
import com.puraskaar.puraskaar.entity.volunteer.Volunteer;
import com.puraskaar.puraskaar.repository.volunteer.VolunteerRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServicesImpl implements VolunteerServices{

    @Autowired
    private VolunteerRegistrationRepository volunteerRegistrationRepository;

    public Volunteer saveRegistrationForm(Volunteer form){
        return volunteerRegistrationRepository.save(form);
    }

    public List<Volunteer> retrieveAllRegistrationForms(){
        return volunteerRegistrationRepository.findAll();
    }

    public Volunteer findRegistrationFormById(Integer id){
        Volunteer volunteer = volunteerRegistrationRepository.findById(id).orElse(null);
        return volunteer;
    }

    public Volunteer updateRegistrationForm(Volunteer form, Integer id){
        this.deleteById(id);
        return volunteerRegistrationRepository.save(form);
    }

    public void deleteById(Integer id){
        Volunteer volunteer = volunteerRegistrationRepository.findById(id).orElse(null);
        if(volunteer !=null) volunteerRegistrationRepository.deleteById(id);
    }
}