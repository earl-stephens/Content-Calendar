package com.example.contentcalendar.repository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.contentcalendar.model.Content;
import com.example.contentcalendar.model.Status;
import com.example.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {

	private final List<Content> contentList = new ArrayList<>();
	
	public ContentCollectionRepository() {
		
	}
	
	public List<Content> findAll() {
		return contentList;
	}
	
	public Optional<Content> findById(Integer id) {
		return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
	}
	
	@PostConstruct
	private void init() {
		Content c = new Content(1, 
								"My First Blog Post",
								"My first blog post",
								Status.IDEA,
								Type.ARTICLE,
								LocalDateTime.now(),
								null,
								"");
		
		contentList.add(c);
	}
	
	public void save(Content content) {
		contentList.removeIf(c -> c.id().equals(content.id()));
		contentList.add(content);
	}
	
	public boolean existsById(int id) {
		return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
	}
}
