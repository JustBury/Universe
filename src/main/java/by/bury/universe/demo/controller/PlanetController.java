package by.bury.universe.demo.controller;

import by.bury.universe.demo.entity.Lord;
import by.bury.universe.demo.entity.Planet;
import by.bury.universe.demo.service.LordService;
import by.bury.universe.demo.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/planet")
public class PlanetController {

    private static final String ID_LORD = "idLord";
    private static final String LIST_PLANETS = "listPlanets";
    private static final String PLANET = "planet";
    private static final String PLANETS = "planets";
    private static final String LORDS = "lords";
    private static final String CREAT_PLANET_VIEW = "creat_planet";
    private static final String UPDATE_PLANET_VIEW = "updatePlanet";
    private static final String PLANET_INFO_VIEW = "planetInformation";
    private static final String REDIRECT_LIST_PLANET = "redirect:/planet/listPlanets";

    @Autowired
    private PlanetService planetService;

    @Autowired
    private LordService lordService;

    @RequestMapping("/listPlanets")
    public ModelAndView showMainPage(ModelAndView modelAndView) {
        List<Planet> planets = planetService.getPlanets();
        modelAndView.setViewName(LIST_PLANETS);
        modelAndView.addObject(PLANETS, planets);
        return modelAndView;
    }

    @RequestMapping("/createPlanet")
    public ModelAndView addNewLord(ModelAndView modelAndView) {
        Planet planet = new Planet();
        List<Lord> lords = lordService.getLords();
        modelAndView.setViewName(CREAT_PLANET_VIEW);
        modelAndView.addObject(LORDS, lords);
        modelAndView.addObject(PLANET, planet);
        return modelAndView;
    }

    @RequestMapping("/updatePlanet/{id}")
    public ModelAndView updatePlanetView(@PathVariable int id, ModelAndView modelAndView) {
        Planet planet = planetService.getPlanet(id);
        List<Lord> lords = lordService.getLords();
        modelAndView.addObject(LORDS, lords);
        modelAndView.addObject(PLANET, planet);
        modelAndView.setViewName(UPDATE_PLANET_VIEW);
        return modelAndView;
    }

    @PostMapping("/savePlanet")
    public String savePlanet(@Valid @ModelAttribute("planet") Planet planet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return CREAT_PLANET_VIEW;
        } else {
            planetService.savePlanet(planet);
            return REDIRECT_LIST_PLANET;
        }
    }

    @PostMapping("/updatePlanet")
    public String updatePlanet(@Valid @ModelAttribute("planet") Planet planet, @RequestParam(ID_LORD) int id) {
        Lord lord = lordService.getLord(id);
        planet.setLord(lord);
        System.out.println(planet + " " + id);
        planetService.updatePlanet(planet);
        return REDIRECT_LIST_PLANET;
    }

    @RequestMapping("/showPlanetInfo/{id}")
    public ModelAndView showPlanetInfo(@PathVariable int id, ModelAndView modelAndView) {
        Planet planet = planetService.getPlanet(id);
        modelAndView.setViewName(PLANET_INFO_VIEW);
        modelAndView.addObject(PLANET, planet);
        return modelAndView;
    }

    @RequestMapping("/deletePlanet/{id}")
    public String deletePlanet(@PathVariable int id) {
        planetService.deletePlanet(id);
        return REDIRECT_LIST_PLANET;
    }
}
