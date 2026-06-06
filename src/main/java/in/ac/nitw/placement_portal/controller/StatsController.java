package in.ac.nitw.placement_portal.controller;

import in.ac.nitw.placement_portal.constants.OfferType;
import in.ac.nitw.placement_portal.dto.PlacementRecordForm;
import in.ac.nitw.placement_portal.pojo.PlacementRecordPojo;
import in.ac.nitw.placement_portal.usecase.StatsUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stats")
@Slf4j
@Validated
public class StatsController {

    @Autowired
    private StatsUseCase statsUseCase;

    @PostMapping
    public ResponseEntity<String> addRecord(@Valid @RequestBody PlacementRecordForm form) {
        log.info("Adding placement record for roll: {}", form.getRollNumber());
        statsUseCase.addRecord(form);
        return ResponseEntity.ok("Record added successfully");
    }

    @GetMapping
    public ResponseEntity<List<PlacementRecordPojo>> getStats(
            @RequestParam OfferType offerType,
            @RequestParam Integer academicYear) {
        return ResponseEntity.ok(statsUseCase.getStats(offerType, academicYear));
    }
}
