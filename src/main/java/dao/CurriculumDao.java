package dao;

import model.Curriculum;

import java.util.List;

public interface CurriculumDao extends DAO<Curriculum> {
    List<Curriculum> findAll();
    Curriculum findById(int id);
}
