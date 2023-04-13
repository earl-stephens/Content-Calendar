package com.example.contentcalendar.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.contentcalendar.model.Content;
import com.example.contentcalendar.repository.ContentRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
	
	private final ContentRepository repository;
	
	@Autowired
	public ContentController(ContentRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("")
	public List<Content> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Content findById(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void create(@Valid @RequestBody Content content) {
		repository.save(content);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void update(@RequestBody Content content, @PathVariable Integer id) {
		if(!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
		}
		repository.save(content);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		repository.deleteById(id);
	}
}
