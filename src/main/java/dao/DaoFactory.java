package dao;

public abstract class DaoFactory {
    private static UserDao userDao;
    private static JobOpportunityDao jobOpportunityDao;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImp();
        }
        return userDao;
    }

    public static JobOpportunityDao getJobOpportunityDao() {
        if (jobOpportunityDao == null) {
            jobOpportunityDao = new JobOpportunityDaoImp();
        }
        return jobOpportunityDao;
    }
}
