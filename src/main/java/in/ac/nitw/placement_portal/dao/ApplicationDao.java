package in.ac.nitw.placement_portal.dao;

import in.ac.nitw.placement_portal.pojo.ApplicationPojo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ApplicationDao extends AbstractDao<ApplicationPojo> {

    @Transactional(readOnly = true)
    public List<ApplicationPojo> findByStudentEmail(String studentEmail) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<ApplicationPojo> cq = cb.createQuery(ApplicationPojo.class);
        Root<ApplicationPojo> root = cq.from(ApplicationPojo.class);
        cq.select(root).where(cb.equal(root.get("studentEmail"), studentEmail));
        return em().createQuery(cq).getResultList();
    }
}
