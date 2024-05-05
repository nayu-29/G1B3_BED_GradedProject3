package com.gl.ticketTracker.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gl.ticketTracker.dto.CommentDto;
import com.gl.ticketTracker.entity.Comment;
import com.gl.ticketTracker.entity.Ticket;
import com.gl.ticketTracker.entity.User;
import com.gl.ticketTracker.mapper.CommentMapper;
import com.gl.ticketTracker.repository.CommentRepository;
import com.gl.ticketTracker.repository.TicketRepository;
import com.gl.ticketTracker.repository.UserRepository;
import com.gl.ticketTracker.service.CommentService;
import com.gl.ticketTracker.util.SecurityUtils;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentRepository commentRepository;
	private TicketRepository ticketRepository;
	private UserRepository userRepository;

	public CommentServiceImpl(CommentRepository commentRepository, TicketRepository ticketRepository,
			UserRepository userRepository) {
		this.commentRepository = commentRepository;
		this.ticketRepository = ticketRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void createComment(String ticketUrl, CommentDto commentDto) {

		Ticket ticket = ticketRepository.findByUrl(ticketUrl).get();
		Comment comment = CommentMapper.mapToComment(commentDto);
		comment.setTicket(ticket);
		commentRepository.save(comment);

	}

	@Override
	public List<CommentDto> findAllComments() {
		List<Comment> comments = commentRepository.findAll();
		return comments.stream().map(CommentMapper::mapToCommentDto).collect(Collectors.toList());
	}

	@Override
	public void deleteComment(Long commentId) {
		commentRepository.deleteById(commentId);

	}

	@Override
	public List<CommentDto> findCommentsByTicket() {
		String email = SecurityUtils.getCurrentUser().getUsername();
		User createdBy = userRepository.findByEmail(email);
		Long userId = createdBy.getId();
		List<Comment> comments = commentRepository.findCommentsByTicket(userId);
		return comments.stream().map((comment) -> CommentMapper.mapToCommentDto(comment)).collect(Collectors.toList());
	}

}
