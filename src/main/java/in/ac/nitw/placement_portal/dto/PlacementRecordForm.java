package in.ac.nitw.placement_portal.dto;

import in.ac.nitw.placement_portal.constants.OfferType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlacementRecordForm {

    @NotBlank
    private String studentName;

    @NotBlank
    private String rollNumber;

    @NotBlank
    private String company;

    @NotBlank
    private String profile;

    @NotBlank
    private String branch;

    @NotNull
    private OfferType offerType;

    @NotNull
    private Integer academicYear;
}
