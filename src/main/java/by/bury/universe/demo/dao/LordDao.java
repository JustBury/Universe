package by.bury.universe.demo.dao;

import by.bury.universe.demo.entity.Lord;
import by.bury.universe.demo.entity.Planet;

import java.util.List;

public interface LordDao {
    public void saveLord(Lord lord);

    public List<Lord> getLords();

    public Lord getLord(int id);

    public void deleteLord(int id);

    public List<Lord> getTenYoungLords();

    public List<Lord> getLordSlackers();
}
