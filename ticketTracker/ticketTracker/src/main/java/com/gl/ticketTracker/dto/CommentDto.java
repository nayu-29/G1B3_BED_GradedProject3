package com.gl.ticketTracker.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private String content;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

}
