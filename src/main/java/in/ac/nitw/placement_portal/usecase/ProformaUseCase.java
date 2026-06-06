package in.ac.nitw.placement_portal.usecase;

import in.ac.nitw.placement_portal.api.ProformaApi;
import in.ac.nitw.placement_portal.dto.ProformaForm;
import in.ac.nitw.placement_portal.pojo.ProformaPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProformaUseCase {

    @Autowired
    private ProformaApi proformaApi;

    public void createProforma(ProformaForm form) {
        ProformaPojo proforma = new ProformaPojo();
        applyForm(proforma, form);
        proformaApi.saveProforma(proforma);
    }

    public List<ProformaPojo> getAllProformas() {
        return proformaApi.getAllProformas();
    }

    public ProformaPojo getProforma(Long id) {
        ProformaPojo proforma = proformaApi.getProforma(id);
        if (proforma == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proforma not found");
        }
        return proforma;
    }

    @Transactional
    public void updateProforma(Long id, ProformaForm form) {
        ProformaPojo proforma = getProforma(id);
        applyForm(proforma, form);
        proformaApi.saveProforma(proforma);
    }

    @Transactional
    public void deleteProforma(Long id) {
        proformaApi.removeProforma(getProforma(id));
    }

    private void applyForm(ProformaPojo proforma, ProformaForm form) {
        proforma.setCompanyName(form.getCompanyName());
        proforma.setJobRole(form.getJobRole());
        proforma.setDriveMode(form.getDriveMode());
        proforma.setCgpaCutoff(form.getCgpaCutoff());
        proforma.setTentativeLocation(form.getTentativeLocation());
        proforma.setCtcBreakup(form.getCtcBreakup());
        proforma.setEligibleBatch(form.getEligibleBatch());
        proforma.setEligibleBranches(form.getEligibleBranches());
        proforma.setDriveInfo(form.getDriveInfo());
        proforma.setAssessmentDates(form.getAssessmentDates());
        proforma.setDeadlineForForm(form.getDeadlineForForm());
        proforma.setSpoc(form.getSpoc());
        proforma.setJobDescriptionUrl(form.getJobDescriptionUrl());
        proforma.setJobDescriptionName(form.getJobDescriptionName());
    }
}
