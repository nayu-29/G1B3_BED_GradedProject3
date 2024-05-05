package com.gl.ticketTracker.service;

import java.util.List;

import com.gl.ticketTracker.dto.CommentDto;

public interface CommentService {

	void createComment(String ticketUrl, CommentDto commentDto);

	List<CommentDto> findAllComments();

	void deleteComment(Long commentId);

	List<CommentDto> findCommentsByTicket();
}
