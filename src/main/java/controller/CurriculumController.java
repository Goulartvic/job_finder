package controller;

import dao.CurriculumDaoInterface;
import dao.DaoFactory;
import dao.UserDaoInterface;
import model.Curriculum;

import java.util.ArrayList;

public class CurriculumController {
    private static CurriculumController curriculumController;

    private CurriculumDaoInterface curriculumDaoInterface = DaoFactory.getCurriculumDaoInterface();
    private UserDaoInterface userDaoInterface = DaoFactory.getUserDaoInterface();

    public static CurriculumController getCurriculumController() {
        if (curriculumController == null) {
            curriculumController = new CurriculumController();
        }
        return curriculumController;
    }

    public void save(Curriculum curriculum) {
        if (curriculum.getId() == 0) {
            curriculumDaoInterface.save(curriculum);
            UserController.getInstance().getSessionUser().setCurriculum(curriculum);
            userDaoInterface.save(UserController.getInstance().getSessionUser());
        } else {
            curriculumDaoInterface.update();
        }
    }

    public ArrayList<Curriculum> listAll() {
        ArrayList<Curriculum> curriculums = (ArrayList<Curriculum>) curriculumDaoInterface.findAll();
        return curriculums;
    }
}
