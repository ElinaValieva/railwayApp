package com.elina.railwayApp.controller;

import com.elina.railwayApp.configuration.common.URLs;
import com.elina.railwayApp.configuration.common.Views;
import com.elina.railwayApp.model.User;
import com.elina.railwayApp.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log4j
@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = URLs.WELCOME)
    public String home(Model model) {
        model.addAttribute("startPage", "Hello beach!");
        model.addAttribute("message", "this is project from Elinaaas");
        return Views.WELCOME;
    }

    @RequestMapping(value = URLs.REGISTRATION, method = RequestMethod.GET)
    public String registration() {
        return Views.REGISTRATION;
    }

    @RequestMapping(value = URLs.LOGIN, method = RequestMethod.GET)
    public String login() {
        return Views.LOGIN;
    }

    @RequestMapping(value = URLs.UPDATE_PROFILE, method = RequestMethod.GET)
    public String getProfile(Model model) {
        /*TODO
        get id user
         */
        User user = userService.findByEmail("veaufa@mail.ru");
        model.addAttribute("user", user);
        return Views.PROFILE;
    }
/*
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @RequestMapping(name = URLs.UPDATE_STATION, method = RequestMethod.POST)
    public String updateStation(@ModelAttribute("station") Station station) {
        stationService.update(station);
        return Views.STATION;
    }*/
}
