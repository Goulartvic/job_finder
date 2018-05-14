package controller;

import dao.DaoFactory;
import dao.JobDaoInterface;
import model.JobOpportunity;
import model.User;

import java.util.ArrayList;

public class JobController {
    JobDaoInterface jobDaoInterface = DaoFactory.getJobDaoInterface();

    public void save(JobOpportunity jobOpportunity) throws Exception {
        if (jobOpportunity.getId() == 0) {
            jobDaoInterface.save(jobOpportunity);
            UserController.getInstance().getSessionUser().setJobOpportunity(jobOpportunity);
            UserController.getInstance().getUserDaoInterface().save(UserController.getInstance().getSessionUser());
        } else {
            jobDaoInterface.update();
        }
    }

    public ArrayList<JobOpportunity> listAll() {
        ArrayList<JobOpportunity> jobs = (ArrayList<JobOpportunity>) jobDaoInterface.findAll();
        return jobs;
    }

    public JobOpportunity jobById(int id) {
        JobOpportunity jobOpportunity = jobDaoInterface.findById(id);
        return jobOpportunity;
    }

    public ArrayList<JobOpportunity> listOpenjobs() {
        ArrayList<JobOpportunity> jobsOpen = (ArrayList<JobOpportunity>) jobDaoInterface.listOpenJobs();
        return jobsOpen;
    }

    public boolean userInJob(JobOpportunity job, int id) {
        for (User user : job.getUsers()) {
            if (user.getId() == UserController.getInstance().getSessionUser().getId()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<JobOpportunity> listJobsByArea(String area) throws Exception {
        if (area != null) {
            ArrayList<JobOpportunity> jobs = (ArrayList<JobOpportunity>) jobDaoInterface.listJobsByArea(area);
            if (jobs != null) {
                return jobs;
            } else {
                throw new Exception("Nenhuma vaga foi encontrada");
            }
        } else {
            throw new Exception("Você deve preencher o campo área");
        }

    }
}
