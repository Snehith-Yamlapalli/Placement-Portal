package in.ac.nitw.placement_portal.controller;

import in.ac.nitw.placement_portal.dto.ApplicationForm;
import in.ac.nitw.placement_portal.pojo.ApplicationPojo;
import in.ac.nitw.placement_portal.usecase.ApplicationUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@Slf4j
@Validated
public class ApplicationController {

    @Autowired
    private ApplicationUseCase applicationUseCase;

    @PostMapping
    public ResponseEntity<String> apply(@Valid @RequestBody ApplicationForm form, Authentication authentication) {
        log.info("Application from {} for proforma {}", authentication.getName(), form.getProformaId());
        applicationUseCase.apply(form, authentication.getName());
        return ResponseEntity.ok("Applied successfully");
    }

    @GetMapping
    public ResponseEntity<List<ApplicationPojo>> getMyApplications(Authentication authentication) {
        return ResponseEntity.ok(applicationUseCase.getMyApplications(authentication.getName()));
    }
}
