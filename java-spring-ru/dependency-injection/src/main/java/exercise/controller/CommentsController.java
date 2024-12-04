package exercise.controller;

import exercise.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("comments")
public class CommentsController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Comment show(@PathVariable Long id) {
        var maybeComm = commentRepository.findById(id);
        if (maybeComm.isEmpty()) {
            throw new ResourceNotFoundException(id + " comment not found");
        }
        return maybeComm.get();
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comm) {
        commentRepository.save(comm);
        return comm;
    }

    @PutMapping(path = "/{id}")
    public Comment update(@RequestBody Comment comm, @PathVariable Long id) {
        var maybeComment = commentRepository.findById(id);
        if (maybeComment.isEmpty()) {
            throw new ResourceNotFoundException(id + " comment not found");
        }
        comm.setId(id);
        commentRepository.save(comm);
        return comm;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        if (!commentRepository.existsById(id)) {
            throw new ResourceNotFoundException(id + " comment not found");
        }
        commentRepository.deleteById(id);
    }
}
// END
