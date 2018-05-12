package dao;

import model.JobOpportunity;
import model.User;

import java.util.List;

public interface JobOpportunityDao extends DAO<JobOpportunity> {
    List<JobOpportunity> findAll();

    JobOpportunity findById(int id);

    List<JobOpportunity> listOpenJobs();

    List<JobOpportunity> listUsersByJob(int id);
}
