package controller;

import dao.DaoFactory;
import dao.JobOpportunityDao;
import model.Curriculum;
import model.JobOpportunity;
import model.User;

import java.util.ArrayList;

public class JobOpportunityController {
    JobOpportunityDao jobOpportunityDao = DaoFactory.getJobOpportunityDao();

    //TODO - buscar usuarios e poder visualizar seus curriculos pela sua vaga cadastada
    public void save(JobOpportunity jobOpportunity) throws Exception {
//        TODO - Fazer verificações
        if (jobOpportunity.getId() == 0) {
            jobOpportunityDao.save(jobOpportunity);
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
        return jobOpportunity;
    }

    public ArrayList<JobOpportunity> listOpenjobs() {
        ArrayList<JobOpportunity> jobsOpen = (ArrayList<JobOpportunity>) jobOpportunityDao.listOpenJobs();
        return jobsOpen;
    }

    public void userInJob() {
        System.out.println(jobOpportunityDao.userInJob(9));
    }
}
