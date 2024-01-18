package puraskaar.services.volunteer_registration;

import puraskaar.entity.volunteer_registration.Volunteer;
import puraskaar.repository.volunteer_registration.VolunteerRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerRegistrationServices {

    VolunteerRegistrationRepository volunteerRegistrationRepository;

    public VolunteerRegistrationServices(VolunteerRegistrationRepository volunteerRegistrationRepository) {
        this.volunteerRegistrationRepository = volunteerRegistrationRepository;
    }

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