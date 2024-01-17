package puraskaar.controller.volunteer_registration;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import puraskaar.entity.volunteer_registration.VolunteerRegistration;
import puraskaar.exceptionhandler.UserNotFoundException;
import puraskaar.services.volunteer_registration.VolunteerRegistrationServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("volunteer-registration")
public class VolunteerRegistrationController {

    private VolunteerRegistrationServices services;

    public VolunteerRegistrationController(VolunteerRegistrationServices services) {
        this.services = services;
    }

    @GetMapping("/forms")
    public List<VolunteerRegistration> retrieveAllRegistrationForms(){
        return services.retrieveAllRegistrationForms();
    }

    @GetMapping("/forms/{id}")
    public VolunteerRegistration retriveRegistrationForm(@PathVariable Integer id){
        VolunteerRegistration volunteer = services.findRegistrationFormById(id);
        if(volunteer==null) throw new UserNotFoundException("Volunteer is not present which id: " + id);
        return volunteer;
    }

    @PostMapping("/forms")
    public ResponseEntity saveRegistrationForm(@RequestBody VolunteerRegistration volunteerRegistration){
        VolunteerRegistration savedForm = services.saveRegistrationForm(volunteerRegistration);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedForm.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/forms/{id}")
    public VolunteerRegistration updateRegistrationForm(@RequestBody VolunteerRegistration volunteerRegistration, @PathVariable Integer id){
        VolunteerRegistration volunteer = services.updateRegistrationForm(volunteerRegistration, id);
        if(volunteer==null) throw new UserNotFoundException("id: " + id);
        return volunteer;
    }

    @DeleteMapping("/forms/{id}")
    public void deleteRegistrationForm(@PathVariable Integer id){
        services.deleteById(id);
    }
}
