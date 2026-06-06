package in.ac.nitw.placement_portal.dao;

import in.ac.nitw.placement_portal.pojo.UserPojo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserDao extends AbstractDao<UserPojo> {

    @Transactional(readOnly = true)
    public Optional<UserPojo> findByEmail(String email) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<UserPojo> cq = cb.createQuery(UserPojo.class);
        Root<UserPojo> root = cq.from(UserPojo.class);
        cq.select(root).where(cb.equal(root.get("email"), email));
        return em().createQuery(cq).getResultStream().findFirst();
    }
}
