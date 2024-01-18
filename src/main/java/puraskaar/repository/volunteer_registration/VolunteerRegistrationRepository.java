package puraskaar.repository.volunteer_registration;

import puraskaar.entity.volunteer_registration.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRegistrationRepository extends JpaRepository <Volunteer, Integer> {
}