package dao;

public abstract class DaoFactory {
    private static UserDao userDao;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImp();
        }
        return null;
    }
}
