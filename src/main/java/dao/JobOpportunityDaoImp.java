package dao;

import model.JobOpportunity;
import model.User;

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

    @Override
    public JobOpportunity findById(int id) {
        Query query = manager.createQuery("FROM JobOpportunity j where j.id =:id ");
        query.setParameter("id", id);
        return (JobOpportunity) query.getSingleResult();
    }

    @Override
    public List<JobOpportunity> listOpenJobs() {
        Query query = manager.createQuery("FROM JobOpportunity j where j.jobStatus = 0");
        return (List<JobOpportunity>) query.getResultList();
    }
}
