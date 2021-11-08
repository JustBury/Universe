package by.bury.universe.demo.service.impl;

import by.bury.universe.demo.dao.PlanetDao;
import by.bury.universe.demo.entity.Planet;
import by.bury.universe.demo.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetDao planetDao;

    @Override
    public void savePlanet(Planet planet) {
    planetDao.savePlanet(planet);
    }

    @Override
    public Planet getPlanet(int id) {
        return planetDao.getPlanet(id);
    }

    @Override
    public List<Planet> getPlanets() {
        return planetDao.getPlanets();
    }

    @Override
    public void deletePlanet(int id) {
        planetDao.deletePlanet(id);
    }

    @Override
    public void updatePlanet(Planet planet) {
        planetDao.updatePlanet(planet);
    }
}
