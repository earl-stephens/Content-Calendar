package com.example.contentcalendar.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record Content(Integer id,
						@NotBlank
						String title,
						@NotBlank
						String desc,
						Status status,
						Type contentType,
						LocalDateTime dateCreated,
						LocalDateTime dateUpdated,
						String url) {
}
