package dao;

import model.JobOpportunity;

import java.util.List;

public interface JobOpportunityDao extends DAO<JobOpportunity> {
    List<JobOpportunity> findAll();
}
