package puraskaar.controller.volunteer;

import puraskaar.entity.volunteer.Volunteer;
import puraskaar.exceptionhandler.UserNotFoundException;
import puraskaar.services.volunteer.VolunteerServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerServicesImpl services;

    @GetMapping("/forms")
    public List<Volunteer> retrieveAllRegistrationForms(){
        return services.retrieveAllRegistrationForms();
    }

    @GetMapping("/forms/{id}")
    public Volunteer retrieveVolunteer(@PathVariable Long id){
        Volunteer volunteer = services.findRegistrationFormById(id);
        if(volunteer==null) throw new UserNotFoundException("Volunteer not found, id: " + id);
        return volunteer;
    }

    @PostMapping("/forms")
    public ResponseEntity saveRegistrationForm(@RequestBody Volunteer volunteer){
        Volunteer savedForm = services.saveRegistrationForm(volunteer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedForm.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/forms/{id}")
    public Volunteer updateRegistrationForm(@RequestBody Volunteer volunteerRegistration, @PathVariable Long id){
        volunteerRegistration.setId(id);
        Volunteer volunteer = services.saveRegistrationForm(volunteerRegistration);
        if(volunteer==null) throw new UserNotFoundException("id: " + id);
        return volunteer;
    }

    @DeleteMapping("/forms/{id}")
    public void deleteRegistrationForm(@PathVariable Long id){
        services.deleteById(id);
    }
}
