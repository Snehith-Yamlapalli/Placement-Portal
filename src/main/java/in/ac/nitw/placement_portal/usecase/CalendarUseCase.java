package in.ac.nitw.placement_portal.usecase;

import in.ac.nitw.placement_portal.api.CalendarEventApi;
import in.ac.nitw.placement_portal.dto.CalendarEventForm;
import in.ac.nitw.placement_portal.pojo.CalendarEventPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CalendarUseCase {

    @Autowired
    private CalendarEventApi calendarEventApi;

    public void createEvent(CalendarEventForm form, String createdBy) {
        CalendarEventPojo event = new CalendarEventPojo();
        event.setTitle(form.getTitle());
        event.setStartTime(form.getStartTime());
        event.setEndTime(form.getEndTime());
        event.setAllDay(form.isAllDay());
        event.setCreatedBy(createdBy);
        calendarEventApi.saveEvent(event);
    }

    public List<CalendarEventPojo> getAllEvents() {
        return calendarEventApi.getAllEvents();
    }

    @Transactional
    public void deleteEvent(Long id, String requestedBy) {
        CalendarEventPojo event = calendarEventApi.getEvent(id);
        if (event == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
        if (!event.getCreatedBy().equals(requestedBy)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You can only delete your own events");
        }
        calendarEventApi.removeEvent(event);
    }
}
