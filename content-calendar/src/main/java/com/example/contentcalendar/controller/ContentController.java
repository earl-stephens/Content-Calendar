package com.example.contentcalendar.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contentcalendar.model.Content;
import com.example.contentcalendar.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {
	
	private final ContentCollectionRepository repository;
	
	@Autowired
	public ContentController(ContentCollectionRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("")
	public List<Content> findAll() {
		return repository.findAll();
	}
}
