package com.api.firstspringproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     private int author_id;
     private String author_Name;
     private String language;
     @OneToOne(mappedBy = "author")
     @JsonBackReference
     private Books book;
     public void setBook(Books book) {
        this.book = book;
    }
    public Books getBook() {
        return book;
    }
    public int getAuthor_id() {
        return author_id;
    }
    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
    public String getAuthor_Name() {
        return author_Name;
    }
    public void setAuthor_Name(String author_Name) {
        this.author_Name = author_Name;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public Author(int author_id, String author_Name, String language) {
        this.author_id = author_id;
        this.author_Name = author_Name;
        this.language = language;
    }
    public Author() {
    }
    @Override
    public String toString() {
        return "Author [author_id=" + author_id + ", author_Name=" + author_Name + ", language=" + language + "]";
    }


     
}
