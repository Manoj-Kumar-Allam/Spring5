package com.ma.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.ma.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
