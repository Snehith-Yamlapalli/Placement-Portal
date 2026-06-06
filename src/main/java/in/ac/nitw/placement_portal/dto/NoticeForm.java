package in.ac.nitw.placement_portal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeForm {

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
