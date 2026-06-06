package in.ac.nitw.placement_portal.controller;

import in.ac.nitw.placement_portal.dto.CalendarEventForm;
import in.ac.nitw.placement_portal.pojo.CalendarEventPojo;
import in.ac.nitw.placement_portal.usecase.CalendarUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
@Slf4j
@Validated
public class CalendarController {

    @Autowired
    private CalendarUseCase calendarUseCase;

    @PostMapping
    public ResponseEntity<String> createEvent(@Valid @RequestBody CalendarEventForm form, Authentication authentication) {
        calendarUseCase.createEvent(form, authentication.getName());
        return ResponseEntity.ok("Event created successfully");
    }

    @GetMapping
    public ResponseEntity<List<CalendarEventPojo>> getAllEvents() {
        return ResponseEntity.ok(calendarUseCase.getAllEvents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id, Authentication authentication) {
        calendarUseCase.deleteEvent(id, authentication.getName());
        return ResponseEntity.ok("Event deleted successfully");
    }
}
