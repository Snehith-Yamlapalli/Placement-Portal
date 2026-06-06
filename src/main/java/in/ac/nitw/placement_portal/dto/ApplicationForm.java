package in.ac.nitw.placement_portal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationForm {

    @NotNull
    private Long proformaId;
}
