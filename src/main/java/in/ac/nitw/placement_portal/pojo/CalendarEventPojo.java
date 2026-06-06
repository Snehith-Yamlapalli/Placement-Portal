package in.ac.nitw.placement_portal.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name = "calendar_events")
@Getter
@Setter
public class CalendarEventPojo extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    @Column(nullable = false)
    private boolean allDay = false;

    @Column(nullable = false)
    private String createdBy;
}
