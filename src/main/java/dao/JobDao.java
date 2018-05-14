package dao;

import model.JobOpportunity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JobDao extends GenericHibernateDao<JobOpportunity> implements JobDaoInterface {

    private EntityManager manager;

    public JobDao() {
        manager = Connection.getEntityManager();
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

    @Override
    public List<JobOpportunity> listJobsByArea(String occupationArea) {
        Query query = manager.createQuery("From JobOpportunity j where j.occupationArea like :occupationArea");
        query.setParameter("occupationArea", "%"+occupationArea+"%");
        return query.getResultList();
    }

}
