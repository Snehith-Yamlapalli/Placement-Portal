package in.ac.nitw.placement_portal.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveStudentForm {

    @NotBlank
    private String rollNumber;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String instituteEmail;

    @Email
    @NotBlank
    private String personalEmail;

    @NotBlank
    private String branch;

    @NotNull
    @Min(1) @Max(5)
    private Integer yearOfStudy;

    @NotNull
    @DecimalMin("0.0") @DecimalMax("10.0")
    private Double cgpa;

}
