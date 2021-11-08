package by.bury.universe.demo.dao.Impl;

import by.bury.universe.demo.dao.PlanetDao;
import by.bury.universe.demo.entity.Planet;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class PlanetDaoImpl implements PlanetDao {

    private static final String PLANET_ID = "id_planet";
    private static final String SELECT_PLANETS = "select P from Planet P";
    private static final String DELETE_PLANET = "delete from Planet where id=:id_planet";

    @Autowired
    private EntityManager entityManager;

    @Override
    public void savePlanet(Planet planet) {
        Session session = entityManager.unwrap(Session.class);
        session.save(planet);
    }

    @Override
    public Planet getPlanet(int id) {
        Session session = entityManager.unwrap(Session.class);
        Planet planet = session.get(Planet.class, id);
        return planet;
    }

    @Override
    public List<Planet> getPlanets() {
        Session session = entityManager.unwrap(Session.class);
        Query<Planet> theQuery = session.createQuery(SELECT_PLANETS, Planet.class);
        List<Planet> planets = theQuery.getResultList();
        return planets;
    }

    @Override
    public void deletePlanet(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery(DELETE_PLANET);
        theQuery.setParameter(PLANET_ID, id);
        theQuery.executeUpdate();
    }

    @Override
    public void updatePlanet(Planet planet) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(planet);
    }
}
