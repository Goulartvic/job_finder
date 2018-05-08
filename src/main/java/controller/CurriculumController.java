package controller;

import dao.CurriculumDao;
import dao.DaoFactory;
import model.Curriculum;

import java.util.ArrayList;

public class CurriculumController {
    CurriculumDao curriculumDao = DaoFactory.getCurriculumDao();

    public void save(Curriculum curriculum) {
        if (curriculum.getId() == 0) {
            curriculumDao.save(curriculum);
        } else {
            curriculumDao.update();
        }
    }

    public ArrayList<Curriculum> listAll() {
        ArrayList<Curriculum> curriculums = (ArrayList<Curriculum>) curriculumDao.findAll();
        return curriculums;
    }
}
