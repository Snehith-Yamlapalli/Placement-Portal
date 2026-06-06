package in.ac.nitw.placement_portal.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class StudentPojo extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String rollNumber;

    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false, unique = true)
    private String instituteEmail;

    @Email
    @Column(nullable = false)
    private String personalEmail;

    @Column(nullable = false)
    private String branch;

    @Column(nullable = false)
    private Integer yearOfStudy;

    @Column(nullable = false)
    private Double cgpa;

    private String phoneNumber;

    private String resumeUrl;

    @Column(nullable = false)
    private boolean gotOffer = false;

    private String placedCompany;
}
