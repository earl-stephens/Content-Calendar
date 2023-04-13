package com.example.contentcalendar.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.example.contentcalendar.model.Content;

public interface ContentRepository extends ListCrudRepository<Content,Integer>{
	
	List<Content> findAllByContentType(String type);
}
