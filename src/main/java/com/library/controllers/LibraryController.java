package com.library.controllers;

import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @RequestMapping("books")
    public String books(Model model) {
        model.addAttribute("listBooks",
                libraryService.getBooks());
        return "home";
    }
}
