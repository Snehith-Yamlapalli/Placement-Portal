package in.ac.nitw.placement_portal.api;

import in.ac.nitw.placement_portal.dao.CalendarEventDao;
import in.ac.nitw.placement_portal.pojo.CalendarEventPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEventApi {

    @Autowired
    private CalendarEventDao calendarEventDao;

    public void saveEvent(CalendarEventPojo event) {
        calendarEventDao.persist(event);
    }

    public CalendarEventPojo getEvent(Long id) {
        return calendarEventDao.select(id);
    }

    public List<CalendarEventPojo> getAllEvents() {
        return calendarEventDao.selectAll();
    }

    public void removeEvent(CalendarEventPojo event) {
        calendarEventDao.remove(event);
    }
}
