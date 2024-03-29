package puraskaar.services.volunteer;

import puraskaar.entity.volunteer.Volunteer;

import java.util.List;

public interface VolunteerServices {
    public Volunteer saveRegistrationForm(Volunteer form);
    public List<Volunteer> retrieveAllRegistrationForms();
    public Volunteer updateRegistrationForm(Volunteer form, Long id);
    public void deleteById(Long id);
}
