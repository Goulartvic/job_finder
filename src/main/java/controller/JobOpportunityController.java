package controller;

import dao.DaoFactory;
import dao.JobOpportunityDao;
import model.JobOpportunity;

import java.util.ArrayList;

public class JobOpportunityController {
    JobOpportunityDao jobOpportunityDao = DaoFactory.getJobOpportunityDao();

    //TODO - buscar usuarios e poder visualizar seus curriculos pela sua vaga cadastada
//    TODO - pode trocar status da vaga
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
}
