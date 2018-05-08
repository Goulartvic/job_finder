package dao;

import model.JobOpportunity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JobOpportunityDaoImp extends GenericHibernateDao<JobOpportunity> implements JobOpportunityDao {

    private EntityManager manager;

    public JobOpportunityDaoImp() {
        manager = ConnectionManager.getEntityManager();
    }

    @Override
    public List<JobOpportunity> findAll() {
        Query query = manager.createQuery("From JobOpportunity ");
        return query.getResultList();
    }
}
