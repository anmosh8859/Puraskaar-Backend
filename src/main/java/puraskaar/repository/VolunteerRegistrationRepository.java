package puraskaar.repository;

import puraskaar.entity.VolunteerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRegistrationRepository extends JpaRepository <VolunteerRegistration, String> {
}