package puraskaar.repository.volunteer;

import puraskaar.entity.volunteer.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRegistrationRepository extends JpaRepository <Volunteer, Long> {}