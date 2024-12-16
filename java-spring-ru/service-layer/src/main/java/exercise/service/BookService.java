package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    BookRepository repository;

    @Autowired
    BookMapper mapper;

    public List<BookDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::map)
                .toList();
    }

    public BookDTO create(BookCreateDTO createData) {
        var createdAuthor = mapper.map(createData);
        repository.save(createdAuthor);
        return mapper.map(createdAuthor);
    }

    public BookDTO findById(Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + "not found"));
        return mapper.map(book);
    }

    public BookDTO update(Long id, BookUpdateDTO updateData) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + "not found"));
        mapper.update(updateData, book);
        repository.save(book);
        return mapper.map(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
