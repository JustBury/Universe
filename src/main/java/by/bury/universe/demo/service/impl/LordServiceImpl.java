package by.bury.universe.demo.service.impl;

import by.bury.universe.demo.dao.LordDao;
import by.bury.universe.demo.entity.Lord;
import by.bury.universe.demo.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LordServiceImpl implements LordService {

    @Autowired
    private LordDao lordDao;

    @Override
    public void saveLord(Lord lord) {
        lordDao.saveLord(lord);
    }

    @Override
    public List<Lord> getLords() {
        return lordDao.getLords();
    }

    @Override
    public Lord getLord(int id) {
        return lordDao.getLord(id);
    }

    @Override
    public void deleteLord(int id) {
        lordDao.deleteLord(id);
    }

    @Override
    public List<Lord> getTenYoungLords() {
        return lordDao.getTenYoungLords();
    }

    @Override
    public List<Lord> getLordSlackers() {
        return lordDao.getLordSlackers();
    }
}
