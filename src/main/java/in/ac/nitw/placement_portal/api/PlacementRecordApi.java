package in.ac.nitw.placement_portal.api;

import in.ac.nitw.placement_portal.constants.OfferType;
import in.ac.nitw.placement_portal.dao.PlacementRecordDao;
import in.ac.nitw.placement_portal.pojo.PlacementRecordPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementRecordApi {

    @Autowired
    private PlacementRecordDao placementRecordDao;

    public void saveRecord(PlacementRecordPojo record) {
        placementRecordDao.persist(record);
    }

    public List<PlacementRecordPojo> getByTypeAndYear(OfferType offerType, Integer academicYear) {
        return placementRecordDao.findByTypeAndYear(offerType, academicYear);
    }
}
