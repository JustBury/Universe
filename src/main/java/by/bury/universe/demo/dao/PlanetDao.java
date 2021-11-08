package by.bury.universe.demo.dao;

import by.bury.universe.demo.entity.Planet;
import java.util.List;

public interface PlanetDao {

    public void savePlanet(Planet planet);

    public Planet getPlanet(int id);

    public List<Planet> getPlanets();

    public void deletePlanet(int id);

    public void updatePlanet(Planet planet);
}
