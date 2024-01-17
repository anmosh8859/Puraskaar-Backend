package puraskaar.services.volunteer_registration;

import puraskaar.entity.volunteer_registration.VolunteerRegistration;
import puraskaar.exceptionhandler.UserNotFoundException;
import puraskaar.repository.volunteer_registration.VolunteerRegistrationRepository;
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

    public VolunteerRegistration findRegistrationFormById(Integer id){
        VolunteerRegistration volunteer = volunteerRegistrationRepository.findById(id).orElse(null);
        if(volunteer==null) throw new UserNotFoundException("id: " + id);
        return volunteer;
    }

    public VolunteerRegistration updateRegistrationForm(VolunteerRegistration form, Integer id){
        this.deleteById(id);
        return volunteerRegistrationRepository.save(form);
    }

    public void deleteById(Integer id){
        VolunteerRegistration volunteerRegistration = volunteerRegistrationRepository.findById(id).orElse(null);
        if(volunteerRegistration !=null) volunteerRegistrationRepository.deleteById(id);
    }
}