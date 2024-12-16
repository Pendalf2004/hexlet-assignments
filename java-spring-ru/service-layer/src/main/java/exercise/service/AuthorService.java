package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    AuthorRepository repository;

    @Autowired
    AuthorMapper mapper;

    public List<AuthorDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::map)
                .toList();
    }

    public AuthorDTO create(AuthorCreateDTO createData) {
        var createdAuthor = mapper.map(createData);
        repository.save(createdAuthor);
        return mapper.map(createdAuthor);
    }

    public AuthorDTO findById(Long id) {
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + "not found"));
        return mapper.map(author);
    }

    public AuthorDTO update(Long id, AuthorUpdateDTO updateData) {
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + "not found"));
        mapper.update(updateData, author);
        repository.save(author);
        return mapper.map(author);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
