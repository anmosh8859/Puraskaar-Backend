package puraskaar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Volunteer-Registration")
public class VolunteerRegistration {

    @Id
    private String user_name;

    @NonNull
    private String first_name;

    @NonNull
    private String last_name;

    @NonNull
    private LocalDate d_o_b;

    @NonNull
    private String address;

    @NonNull
    private String city_name;

    @NonNull
    private Integer pin_code;

    private @NonNull String phone_number;

    @NonNull
    private String applied_department;

    private String teaching_subject;

    @NonNull
    private Integer working_hours;

    @NonNull
    private Boolean agreement;
}
