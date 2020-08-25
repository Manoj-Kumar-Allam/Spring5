package com.ma.spring5webapp.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ma.spring5webapp.model.Author;
import com.ma.spring5webapp.model.Book;
import com.ma.spring5webapp.model.Dummy;
import com.ma.spring5webapp.model.Publisher;
import com.ma.spring5webapp.repository.AuthorRepository;
import com.ma.spring5webapp.repository.BookRepository;
import com.ma.spring5webapp.repository.DummyRepository;
import com.ma.spring5webapp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	private final DummyRepository dummyRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, DummyRepository dummyRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
		this.dummyRepository = dummyRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Author manoj = new Author("Manoj", "Kumar");
		
		Book book = new Book("Spring Basic", "105-2783-2342-12");
		
		Publisher vgs = new Publisher("VGS", "Ramalayam", "Ongole", "AP", "423");
		
		List<String> na = new ArrayList<>();
		na.add("manoj");
		
		Dummy dd = new Dummy();
		dd.setNames(na);
		
		manoj.getBooks().add(book);
		
		book.getAuthors().add(manoj);
		
		book.setPublisher(vgs);
		
		vgs.getBooks().add(book);
		
		System.out.println("Started in Bootstrap");
		
		authorRepository.save(manoj);
		bookRepository.save(book);
		publisherRepository.save(vgs);
		dummyRepository.save(dd);
		
		System.out.println("Ended in BootStrap");
		
		System.out.println("Number of Books Inserted : " + bookRepository.count());
		System.out.println("Number of Publishers Inserted : " + vgs.getBooks().size());
		
	}

}
