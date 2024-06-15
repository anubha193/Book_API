package com.api.firstspringproject.bookservices;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.firstspringproject.Dao.BookRepository;
import com.api.firstspringproject.entities.Books;
@Component
public class BookServices {
   
  @Autowired
  private BookRepository bookRepository;
    public ArrayList<Books> getAllBooks()
    {
       ArrayList<Books> al=(ArrayList<Books>) bookRepository.findAll();
        return al;
    }
    public Books getBookById(int id){
        Books bk=null;
        try{
            bk=this.bookRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       return bk;
    }
    public Books getBookByName(String name)
    { Books book=null;
        book=bookRepository.findByTitle(name);
      return book; 
    }
    public Books addBook(Books book)
    {
      Books result= bookRepository.save(book);
       return result;
    }
    public Books deleteById(int id)
    {
        bookRepository.deleteById(id);
        return bookRepository.findById(id);
    }

    public void updateBooks(Books book, int id)
    {
        book.setId(id);
        bookRepository.save(book);
        }
    }


