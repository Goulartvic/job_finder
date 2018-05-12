package controller;

import dao.DaoFactory;
import dao.JobOpportunityDao;
import model.Curriculum;
import model.JobOpportunity;

import java.util.ArrayList;

public class JobOpportunityController {
    JobOpportunityDao jobOpportunityDao = DaoFactory.getJobOpportunityDao();

    //TODO - buscar usuarios e poder visualizar seus curriculos pela sua vaga cadastada
    public void save(JobOpportunity jobOpportunity) throws Exception {
//        TODO - Fazer verificações
        if (jobOpportunity.getId() == 0) {
            jobOpportunityDao.save(jobOpportunity);
            System.out.println("Usuario dono da vaga- " + UserController.getInstance().getSessionUser());
            UserController.getInstance().getSessionUser().setJobOpportunity(jobOpportunity);
            UserController.getInstance().getUserDao().save(UserController.getInstance().getSessionUser());
        } else {
            jobOpportunityDao.update();
        }
    }

    public ArrayList<JobOpportunity> listAll() {
        ArrayList<JobOpportunity> jobs = (ArrayList<JobOpportunity>) jobOpportunityDao.findAll();
        return jobs;
    }

    public JobOpportunity jobById(int id) {
        JobOpportunity jobOpportunity = jobOpportunityDao.findById(id);
        System.out.println("jobid " + jobOpportunity);
        return jobOpportunity;
    }

    public ArrayList<JobOpportunity> listOpenjobs() {
        ArrayList<JobOpportunity> jobsOpen = (ArrayList<JobOpportunity>) jobOpportunityDao.listOpenJobs();
        return jobsOpen;
    }
}
