package dao;

import model.JobOpportunity;

import java.util.List;

public class JobOpportunityDaoImp extends GenericHibernateDao<JobOpportunity> implements JobOpportunityDao {
    @Override
    public List<JobOpportunity> findAll() {
        return null;
    }
}
