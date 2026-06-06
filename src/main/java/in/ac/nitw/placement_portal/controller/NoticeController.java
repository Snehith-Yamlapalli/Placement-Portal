package in.ac.nitw.placement_portal.controller;

import in.ac.nitw.placement_portal.dto.NoticeForm;
import in.ac.nitw.placement_portal.pojo.NoticePojo;
import in.ac.nitw.placement_portal.usecase.NoticeUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
@Slf4j
@Validated
public class NoticeController {

    @Autowired
    private NoticeUseCase noticeUseCase;

    @PostMapping
    public ResponseEntity<String> createNotice(@Valid @RequestBody NoticeForm form, Authentication authentication) {
        log.info("Creating notice: {}", form.getTitle());
        noticeUseCase.createNotice(form, authentication.getName());
        return ResponseEntity.ok("Notice created successfully");
    }

    @GetMapping
    public ResponseEntity<List<NoticePojo>> getAllNotices() {
        return ResponseEntity.ok(noticeUseCase.getAllNotices());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotice(@PathVariable Long id) {
        noticeUseCase.deleteNotice(id);
        return ResponseEntity.ok("Notice deleted successfully");
    }
}
