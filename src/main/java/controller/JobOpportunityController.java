package controller;

import dao.DaoFactory;
import dao.JobOpportunityDao;
import model.JobOpportunity;

import java.util.ArrayList;

public class JobOpportunityController {
    JobOpportunityDao jobOpportunityDao = DaoFactory.getJobOpportunityDao();
//TODO - buscar usuarios por vaga
    public void save(JobOpportunity jobOpportunity) throws Exception {
//        TODO - Fazer verificações
        if (jobOpportunity.getId() == 0) {
            System.out.println("controller" + jobOpportunity);
            jobOpportunityDao.save(jobOpportunity);
        } else {
            jobOpportunityDao.update();
        }
    }

    public ArrayList<JobOpportunity> listAll() {
        ArrayList<JobOpportunity> jobs = (ArrayList<JobOpportunity>) jobOpportunityDao.findAll();
        return jobs;
    }
}
