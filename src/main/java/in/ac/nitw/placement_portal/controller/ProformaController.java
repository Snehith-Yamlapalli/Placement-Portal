package in.ac.nitw.placement_portal.controller;

import in.ac.nitw.placement_portal.dto.ProformaForm;
import in.ac.nitw.placement_portal.pojo.ProformaPojo;
import in.ac.nitw.placement_portal.usecase.ProformaUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proforma")
@Slf4j
@Validated
public class ProformaController {

    @Autowired
    private ProformaUseCase proformaUseCase;

    @PostMapping
    public ResponseEntity<String> createProforma(@Valid @RequestBody ProformaForm form) {
        log.info("Creating proforma for company: {}", form.getCompanyName());
        proformaUseCase.createProforma(form);
        return ResponseEntity.ok("Proforma created successfully");
    }

    @GetMapping
    public ResponseEntity<List<ProformaPojo>> getAllProformas() {
        return ResponseEntity.ok(proformaUseCase.getAllProformas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProformaPojo> getProforma(@PathVariable Long id) {
        return ResponseEntity.ok(proformaUseCase.getProforma(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProforma(@PathVariable Long id, @Valid @RequestBody ProformaForm form) {
        proformaUseCase.updateProforma(id, form);
        return ResponseEntity.ok("Proforma updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProforma(@PathVariable Long id) {
        proformaUseCase.deleteProforma(id);
        return ResponseEntity.ok("Proforma deleted successfully");
    }
}
