package com.puraskaar.puraskaar.services.volunteer;

import com.puraskaar.puraskaar.entity.volunteer.Volunteer;

import java.util.List;

public interface VolunteerServices {
    public Volunteer saveRegistrationForm(Volunteer form);
    public List<Volunteer> retrieveAllRegistrationForms();
    public Volunteer updateRegistrationForm(Volunteer form, Integer id);
    public void deleteById(Integer id);
}
