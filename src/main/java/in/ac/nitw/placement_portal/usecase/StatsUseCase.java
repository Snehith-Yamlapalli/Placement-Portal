package in.ac.nitw.placement_portal.usecase;

import in.ac.nitw.placement_portal.api.PlacementRecordApi;
import in.ac.nitw.placement_portal.constants.OfferType;
import in.ac.nitw.placement_portal.dto.PlacementRecordForm;
import in.ac.nitw.placement_portal.pojo.PlacementRecordPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsUseCase {

    @Autowired
    private PlacementRecordApi placementRecordApi;

    public void addRecord(PlacementRecordForm form) {
        PlacementRecordPojo record = new PlacementRecordPojo();
        record.setStudentName(form.getStudentName());
        record.setRollNumber(form.getRollNumber());
        record.setCompany(form.getCompany());
        record.setProfile(form.getProfile());
        record.setBranch(form.getBranch());
        record.setOfferType(form.getOfferType());
        record.setAcademicYear(form.getAcademicYear());
        placementRecordApi.saveRecord(record);
    }

    public List<PlacementRecordPojo> getStats(OfferType offerType, Integer academicYear) {
        return placementRecordApi.getByTypeAndYear(offerType, academicYear);
    }
}
