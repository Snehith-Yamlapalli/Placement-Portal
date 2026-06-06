package in.ac.nitw.placement_portal.dao;

import in.ac.nitw.placement_portal.constants.OfferType;
import in.ac.nitw.placement_portal.pojo.PlacementRecordPojo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PlacementRecordDao extends AbstractDao<PlacementRecordPojo> {

    @Transactional(readOnly = true)
    public List<PlacementRecordPojo> findByTypeAndYear(OfferType offerType, Integer academicYear) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<PlacementRecordPojo> cq = cb.createQuery(PlacementRecordPojo.class);
        Root<PlacementRecordPojo> root = cq.from(PlacementRecordPojo.class);
        cq.select(root).where(
                cb.equal(root.get("offerType"), offerType),
                cb.equal(root.get("academicYear"), academicYear)
        );
        return em().createQuery(cq).getResultList();
    }
}
