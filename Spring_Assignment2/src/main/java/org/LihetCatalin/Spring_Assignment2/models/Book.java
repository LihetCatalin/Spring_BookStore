package org.LihetCatalin.Spring_Assignment2.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;

@Entity
public class Book extends AbstractEntity{

    @NotBlank(message = "Author is required!")
    private String author;

    @NotBlank(message = "Title is required!")
    private String title;
    private LocalDate publishedDate;

    @NotNull
    private int price;

    @NotNull
    private int stock;

    public Book(){}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publishedDate=" + publishedDate +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
