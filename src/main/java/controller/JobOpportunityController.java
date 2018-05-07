package controller;

import dao.DaoFactory;
import dao.JobOpportunityDao;
import model.JobOpportunity;

public class JobOpportunityController {
    JobOpportunityDao jobOpportunityDao = DaoFactory.getJobOpportunityDao();

    public void save(JobOpportunity jobOpportunity) throws Exception {
//        TODO - Fazer verificações
        if (jobOpportunity.getId() == 0) {
            jobOpportunityDao.save(jobOpportunity);
        } else {
            jobOpportunityDao.update();
        }
    }
}
