package in.ac.nitw.placement_portal.controller;

import in.ac.nitw.placement_portal.dto.SaveStudentForm;
import in.ac.nitw.placement_portal.usecase.StudentUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Slf4j
@Validated
public class StudentController {

    @Autowired
    private StudentUseCase studentUseCase;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudentDetails(@Valid @RequestBody SaveStudentForm form) {
        log.info("Saving student details for rollNumber: {}", form.getRollNumber());
        studentUseCase.saveStudentDetails(form);
        return ResponseEntity.ok("Student saved successfully");
    }
}
