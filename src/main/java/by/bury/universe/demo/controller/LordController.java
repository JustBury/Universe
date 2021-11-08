package by.bury.universe.demo.controller;


import by.bury.universe.demo.entity.Lord;
import by.bury.universe.demo.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LordController {

    private static final String LORD = "lord";
    private static final String LORDS = "lords";
    private static final String CREAT_LORD_VIEW = "creat-new-lord";
    private static final String LIST_LORD_PLANETS_VIEW = "listLordPlanets";
    private static final String LIST_TEN_YOUNGER_LORD_VIEW = "listTenYoungLords";
    private static final String LIST_LORDS_IDLENESS_VIEW = "listLordsIdleness";
    private static final String MAIN_PAGE_VIEW = "main-page";

    @Autowired
    private LordService lordService;

    @RequestMapping("/")
    public ModelAndView showMainPage(ModelAndView modelAndView) {
        List<Lord> lords = lordService.getLords();
        modelAndView.setViewName(MAIN_PAGE_VIEW);
        modelAndView.addObject(LORDS, lords);
        return modelAndView;
    }


    @RequestMapping("/createLord")
    public ModelAndView addNewLord(ModelAndView modelAndView) {
        modelAndView.setViewName(CREAT_LORD_VIEW);
        Lord lord = new Lord();
        modelAndView.addObject(LORD, lord);
        return modelAndView;
    }

    @PostMapping("/saveLord")
    public String saveLord(@Valid @ModelAttribute("lord") Lord lord, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("1");
            return CREAT_LORD_VIEW;
        } else {
            System.out.println("2");
            lordService.saveLord(lord);
            return "redirect:/";
        }
    }

    @RequestMapping("/getLordPlanets/{id}")
    public ModelAndView getLordPlanets(@PathVariable int id, ModelAndView modelAndView) {
        System.out.println(id);
        Lord lord = lordService.getLord(id);
        modelAndView.addObject(LORD, lord);
        modelAndView.setViewName(LIST_LORD_PLANETS_VIEW);
        return modelAndView;
    }

    @RequestMapping("/getTenYoungLords")
    public ModelAndView getTenYoungLords(ModelAndView modelAndView) {
        List<Lord> lords = lordService.getTenYoungLords();
        modelAndView.setViewName(LIST_TEN_YOUNGER_LORD_VIEW);
        modelAndView.addObject(LORDS, lords);
        return modelAndView;
    }

    @RequestMapping("/getLordSlackers")
    public ModelAndView getLordSlackers(ModelAndView modelAndView) {
        List<Lord> lords = lordService.getLordSlackers();
        modelAndView.setViewName(LIST_LORDS_IDLENESS_VIEW);
        modelAndView.addObject(LORDS, lords);
        return modelAndView;
    }
}
