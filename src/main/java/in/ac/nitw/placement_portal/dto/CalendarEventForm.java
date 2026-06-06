package in.ac.nitw.placement_portal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class CalendarEventForm {

    @NotBlank
    private String title;

    @NotNull
    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    private boolean allDay = false;
}
