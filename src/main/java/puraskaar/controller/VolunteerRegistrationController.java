package puraskaar.controller;

import puraskaar.entity.VolunteerRegistration;
import puraskaar.services.VolunteerRegistrationServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public VolunteerRegistration retriveRegistrationForm(@PathVariable String id){
        try {
            VolunteerRegistration form = services.findRegistrationFormById(id);
            return form;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/forms")
    public ResponseEntity saveRegistrationForm(@RequestBody VolunteerRegistration volunteerRegistration){
        VolunteerRegistration savedForm = services.saveRegistrationForm(volunteerRegistration);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/forms/{id}")
    public VolunteerRegistration updateRegistrationForm(@RequestBody VolunteerRegistration volunteerRegistration, @PathVariable String id){
        return services.updateRegistrationForm(volunteerRegistration,id);
    }

    @DeleteMapping("/forms/{id}")
    public void deleteRegistrationForm(@PathVariable String id){
        services.deleteById(id);
    }
}
