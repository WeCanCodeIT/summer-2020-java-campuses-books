package org.wcci.campuslibraries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.campuslibraries.storage.AuthorStorage;
import org.wcci.campuslibraries.storage.CampusStorage;

@Controller
public class HomeController {

    private final CampusStorage campusStorage;
    private final AuthorStorage authorStorage;

    public HomeController(CampusStorage campusStorage, AuthorStorage authorStorage) {
        this.campusStorage = campusStorage;
        this.authorStorage = authorStorage;
    }

    @RequestMapping({"", "/"})
    public String routeToCampuses(Model model) {
        model.addAttribute("campuses", campusStorage.findAllCampuses());
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "home-template";
    }
}
