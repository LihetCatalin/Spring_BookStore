package org.LihetCatalin.Spring_Assignment2.controllers;

import jakarta.validation.Valid;
import org.LihetCatalin.Spring_Assignment2.data.BookRepository;
import org.LihetCatalin.Spring_Assignment2.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String displayAllBooks(Model model){
        model.addAttribute("title", "Retrieve Books");
        model.addAttribute("books", bookRepository.findAll());
        return "books/index";
    }

    @GetMapping("create")
    public String displayCreateBookForm(Model model){
        model.addAttribute("title", "Create Book");
        model.addAttribute(new Book());
        return "books/create";
    }

    @PostMapping("create")
    public String processCreateBookForm(@ModelAttribute @Valid Book newBook,
                                        Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Book");
            return "books/create";
        }

        bookRepository.save(newBook);
        return "redirect:/books";
    }

    @GetMapping("update")
    public String displayUpdateBookForm(Model model){
        model.addAttribute("title", "Update Book");
        int idToUpdate = 0;
        model.addAttribute("IdToUpdate", idToUpdate);
        model.addAttribute(new Book());
        return "books/update";
    }

    @PostMapping("update")
    public String processUpdateBookForm(@RequestParam(required = false) Integer idToUpdate,
                                        @ModelAttribute @Valid Book newBook,
                                        Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Update Book");
            return "books/update";
        }else if(!bookRepository.existsById(idToUpdate.intValue())){
            model.addAttribute("errMsg"
                    , "Book with this Id does not exist!");
            return "books/update";
        }

        bookRepository.save(newBook);
        return "redirect:/books";
    }

    @GetMapping("delete")
    public String displayDeleteBooksForm(Model model){
        model.addAttribute("title", "Delete Books");
        model.addAttribute("books", bookRepository.findAll());
        return "books/delete";
    }

    @PostMapping("delete")
    public String processDeleteBookForm(@RequestParam(required = false) int[] bookIds){
        if(bookIds != null){
            for (int id:bookIds){
                bookRepository.deleteById(id);
            }
        }
        return "redirect:/books";
    }
}
