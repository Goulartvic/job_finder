package dao;

import model.JobOpportunity;
import model.User;

import java.util.List;

public interface JobDaoInterface extends DAO<JobOpportunity> {
    List<JobOpportunity> findAll();

    JobOpportunity findById(int id);

    List<JobOpportunity> listOpenJobs();

    List<JobOpportunity> listJobsByArea(String area);
}
