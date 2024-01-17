package puraskaar.services;

import puraskaar.entity.VolunteerRegistration;
import puraskaar.repository.VolunteerRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerRegistrationServices {

    VolunteerRegistrationRepository volunteerRegistrationRepository;

    public VolunteerRegistrationServices(VolunteerRegistrationRepository volunteerRegistrationRepository) {
        this.volunteerRegistrationRepository = volunteerRegistrationRepository;
    }

    public VolunteerRegistration saveRegistrationForm(VolunteerRegistration form){
        return volunteerRegistrationRepository.save(form);
    }

    public List<VolunteerRegistration> retrieveAllRegistrationForms(){
        return volunteerRegistrationRepository.findAll();
    }

    public VolunteerRegistration findRegistrationFormById(String id){
        return volunteerRegistrationRepository.findById(id).orElse(null);
    }

    public VolunteerRegistration updateRegistrationForm(VolunteerRegistration form, String id){
        this.deleteById(id);
        return volunteerRegistrationRepository.save(form);
    }

    public void deleteById(String id){
        VolunteerRegistration volunteerRegistration = volunteerRegistrationRepository.findById(id).orElse(null);
        if(volunteerRegistration !=null) volunteerRegistrationRepository.deleteById(id);
    }
}