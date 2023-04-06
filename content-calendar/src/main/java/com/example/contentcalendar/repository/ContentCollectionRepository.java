package com.example.contentcalendar.repository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.contentcalendar.model.*;

import org.springframework.stereotype.Repository;

import com.example.contentcalendar.model.Content;

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
		contentList.add(content);
	}
}
