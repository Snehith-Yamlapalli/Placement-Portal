package in.ac.nitw.placement_portal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<T> {
    @PersistenceContext
    protected EntityManager em;

    private Class<T> clazz;

    public AbstractDao() {
        this.clazz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected EntityManager em(){return this.em;}

    protected CriteriaBuilder getCriteriaBuilder(){return this.em.getCriteriaBuilder();}

    @Transactional
    protected TypedQuery<T> createQuery(CriteriaQuery<T> cq){return this.em.createQuery(cq);}

    @Transactional(readOnly = true)
    protected TypedQuery<T> getSelectQuery(){
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(this.clazz);
        Root<T> r = cq.from(this.clazz);
        cq.select(r);
        return this.createQuery(cq);
    }

    @Transactional
    public void persist(T entity){
        this.em.persist(entity);
    }

    @Transactional
    public void update(T enntity){
    }

    @Transactional
    public void remove(T entity){
        this.em.remove(entity);
    }
}
