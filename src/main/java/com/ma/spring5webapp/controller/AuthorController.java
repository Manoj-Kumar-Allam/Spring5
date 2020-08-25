package com.ma.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ma.spring5webapp.repository.AuthorRepository;

@Controller
public class AuthorController {

	private final AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping(value = "/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", this.authorRepository.findAll());
		return "authors/author_list";
	}
}
