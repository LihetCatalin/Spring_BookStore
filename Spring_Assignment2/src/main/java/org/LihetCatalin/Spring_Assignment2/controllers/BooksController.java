package org.LihetCatalin.Spring_Assignment2.controllers;

import jakarta.validation.Valid;
import org.LihetCatalin.Spring_Assignment2.data.BookRepository;
import org.LihetCatalin.Spring_Assignment2.models.Book;
import org.LihetCatalin.Spring_Assignment2.models.auxModels.BookAuxData;
import org.LihetCatalin.Spring_Assignment2.service.BookService;
import org.LihetCatalin.Spring_Assignment2.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String displayAllBooks(Model model){
        model.addAttribute("title", "Retrieve Books");
        model.addAttribute("books", bookService.findAll());
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

        bookService.save(newBook);
        return "redirect:/books";
    }

    @GetMapping("update")
    public String displayUpdateBookForm(Model model){
        model.addAttribute("title", "Update Book");
        model.addAttribute("auxData", new BookAuxData());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute(new Book());
        return "books/update";
    }

    @PostMapping("update")
    public String processUpdateBookForm(@ModelAttribute BookAuxData bookAuxData,
                                        @ModelAttribute @Valid Book newBook,
                                        Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Update Book");
            model.addAttribute("errMsg", "Some error happened!");
            return "books/update";
        }else if(!bookService.existsById(bookAuxData.getIdToUpdate())){
            model.addAttribute("errMsg"
                    , "Book with this Id does not exist!");
            return "books/update";
        }
        Book bookToUpdate = bookService.findById(bookAuxData.getIdToUpdate()).get();
        bookToUpdate.setAuthor(newBook.getAuthor());
        bookToUpdate.setTitle(newBook.getTitle());
        bookToUpdate.setPublishedDate(newBook.getPublishedDate());
        bookToUpdate.setPrice(newBook.getPrice());
        bookToUpdate.setStock(newBook.getStock());
        bookService.save(bookToUpdate);
        return "redirect:/books";
    }

    @GetMapping("delete")
    public String displayDeleteBooksForm(Model model){
        model.addAttribute("title", "Delete Books");
        model.addAttribute("books", bookService.findAll());
        return "books/delete";
    }

    @PostMapping("delete")
    public String processDeleteBookForm(@RequestParam(required = false) int[] bookIds){
        if(bookIds != null){
            for (int id:bookIds){
                bookService.removeById(id);
            }
        }
        return "redirect:/books";
    }
}
