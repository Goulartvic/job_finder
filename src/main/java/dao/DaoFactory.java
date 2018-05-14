package dao;

public abstract class DaoFactory {
    private static UserDaoInterface userDaoInterface;
    private static JobDaoInterface jobDaoInterface;
    private static CurriculumDaoInterface curriculumDaoInterface;

    public static UserDaoInterface getUserDaoInterface() {
        if (userDaoInterface == null) {
            userDaoInterface = new UserDao();
        }
        return userDaoInterface;
    }

    public static JobDaoInterface getJobDaoInterface() {
        if (jobDaoInterface == null) {
            jobDaoInterface = new JobDao();
        }
        return jobDaoInterface;
    }

    public static CurriculumDaoInterface getCurriculumDaoInterface() {
        if (curriculumDaoInterface == null) {
            curriculumDaoInterface = new CurriculumDao();
        }
        return curriculumDaoInterface;
    }
}
