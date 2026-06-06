package in.ac.nitw.placement_portal.usecase;

import in.ac.nitw.placement_portal.api.ApplicationApi;
import in.ac.nitw.placement_portal.api.ProformaApi;
import in.ac.nitw.placement_portal.dto.ApplicationForm;
import in.ac.nitw.placement_portal.pojo.ApplicationPojo;
import in.ac.nitw.placement_portal.pojo.ProformaPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ApplicationUseCase {

    @Autowired
    private ApplicationApi applicationApi;

    @Autowired
    private ProformaApi proformaApi;

    public void apply(ApplicationForm form, String studentEmail) {
        ProformaPojo proforma = proformaApi.getProforma(form.getProformaId());
        if (proforma == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proforma not found");
        }

        boolean alreadyApplied = applicationApi.getByStudentEmail(studentEmail).stream()
                .anyMatch(a -> a.getProforma().getId().equals(form.getProformaId()));
        if (alreadyApplied) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Already applied to this proforma");
        }

        ApplicationPojo application = new ApplicationPojo();
        application.setStudentEmail(studentEmail);
        application.setProforma(proforma);
        applicationApi.saveApplication(application);
    }

    public List<ApplicationPojo> getMyApplications(String studentEmail) {
        return applicationApi.getByStudentEmail(studentEmail);
    }
}
