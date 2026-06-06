package in.ac.nitw.placement_portal.dto;

import in.ac.nitw.placement_portal.constants.DriveMode;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class ProformaForm {

    @NotBlank
    private String companyName;

    @NotBlank
    private String jobRole;

    @NotNull
    private DriveMode driveMode;

    @DecimalMin("0.0") @DecimalMax("10.0")
    private Double cgpaCutoff;

    private String tentativeLocation;

    private String ctcBreakup;

    private List<String> eligibleBatch;

    private List<String> eligibleBranches;

    private String driveInfo;

    private List<ZonedDateTime> assessmentDates;

    private ZonedDateTime deadlineForForm;

    private String spoc;

    private String jobDescriptionUrl;

    private String jobDescriptionName;
}
