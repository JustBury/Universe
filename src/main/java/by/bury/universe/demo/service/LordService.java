package by.bury.universe.demo.service;

import by.bury.universe.demo.entity.Lord;

import java.util.List;

public interface LordService {

    public void saveLord(Lord lord);

    public List<Lord> getLords();

    public Lord getLord(int id);

    public void deleteLord(int id);

    public List<Lord> getTenYoungLords();

    public List<Lord> getLordSlackers();

}
