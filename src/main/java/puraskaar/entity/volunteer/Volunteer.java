package puraskaar.entity.volunteer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "pincode", nullable = false)
    private int pincode;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "applied_department", nullable = false)
    private String appliedDepartment;

    @Column(name = "teaching_department")
    private String teachingDepartment;

    @Column(name = "working_hours", nullable = false)
    private int workingHours;

    @Column(name = "aadhaar_number", nullable = false)
    private String aadhaarNumber;

    @Column(name = "aadhaar_filepath")
    private String aadhaarFilepath;

    @Column(name = "driving_license_number", nullable = false)
    private String drivingLicenseNumber;

    @Column(name = "driving_license_filepath")
    private String drivingLicenseFilepath;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @Column(name = "passport_filepath")
    private String passportFilepath;

    @Column(name = "photo_filepath")
    private String photoFilepath;

    @Column(name = "resume_filepath")
    private String resumeFilepath;

}
