package com.api.firstspringproject.Dao;

import org.springframework.data.repository.CrudRepository;

import com.api.firstspringproject.entities.Books;

public interface BookRepository extends CrudRepository<Books, Integer>{
    public Books findById(int id);
    public Books findByTitle(String title);
    
}
