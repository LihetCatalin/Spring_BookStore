package org.LihetCatalin.Spring_Assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("books")
public class BooksController {


    @GetMapping
    public String displayAllBooks(Model model){
        model.addAttribute("title", "All Books");
        return "books/index";
    }

    @GetMapping("create")
    public String displayCreateBookForm(Model model){
        model.addAttribute("title", "Create Book");
        return "books/create";
    }

    @GetMapping("update")
    public String displayUpdateBookForm(Model model){
        model.addAttribute("title", "Update Book");
        return "books/update";
    }

    @GetMapping("delete")
    public String displayDeleteBooksForm(Model model){
        model.addAttribute("title", "Delete Books");
        return "books/delete";
    }
}
