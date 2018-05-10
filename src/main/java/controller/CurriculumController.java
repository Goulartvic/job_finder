package controller;

import dao.CurriculumDao;
import dao.DaoFactory;
import dao.UserDao;
import model.Curriculum;

import java.util.ArrayList;

public class CurriculumController {
    private static CurriculumController instance;

    private CurriculumDao curriculumDao = DaoFactory.getCurriculumDao();
    private UserDao userDao = DaoFactory.getUserDao();

    public static CurriculumController getInstance() {
        if (instance == null) {
            instance = new CurriculumController();
        }
        return instance;
    }

    public void save(Curriculum curriculum) {
//        TODO - Fazer validações
        if (curriculum.getId() == 0) {
            curriculumDao.save(curriculum);
            UserController.getInstance().getSessionUser().setCurriculum(curriculum);
            userDao.save(UserController.getInstance().getSessionUser());
        } else {
            curriculumDao.update();
        }
    }

    public ArrayList<Curriculum> listAll() {
        ArrayList<Curriculum> curriculums = (ArrayList<Curriculum>) curriculumDao.findAll();
        return curriculums;
    }
}
