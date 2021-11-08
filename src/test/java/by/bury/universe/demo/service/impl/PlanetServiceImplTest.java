package by.bury.universe.demo.service.impl;

import by.bury.universe.demo.entity.Lord;
import by.bury.universe.demo.entity.Planet;
import by.bury.universe.demo.service.PlanetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlanetServiceImplTest {

    @Autowired
    private PlanetService planetService;

    @Test
    @DisplayName("Check save, get and delete planet")
    void savePlanet() {
        Planet planet = new Planet();
        planet.setName("TestPlanet");
        planetService.savePlanet(planet);
        Planet newPlanet = planetService.getPlanet(planet.getId());
        Assertions.assertEquals(planet, newPlanet);
        planetService.deletePlanet(planet.getId());
    }

    @Test
    void updatePlanet() {
        Planet planet = new Planet();
        planet.setName("TestPlanet");
        planetService.savePlanet(planet);
        Planet beforePlanet = planetService.getPlanet(planet.getId());
        beforePlanet.setName("TestPlanet2");
        planetService.updatePlanet(beforePlanet);
        Planet afterPlanet = planetService.getPlanet(planet.getId());
        Assertions.assertEquals(beforePlanet, afterPlanet);
        planetService.deletePlanet(afterPlanet.getId());
    }
}