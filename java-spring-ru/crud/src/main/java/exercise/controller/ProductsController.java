package exercise.controller;

import java.util.List;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> index() {
        return productRepository.findAll().stream()
                .map(productMapper::map)
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO show(@PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return productMapper.map(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @PostMapping("")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductCreateDTO createData) {
        if(categoryRepository.existsById(createData.getCategoryId())) {
            var newProduct = productMapper.map(createData);
            productRepository.save(newProduct);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(productMapper.map(newProduct));
        } else return ResponseEntity.badRequest()
                .body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductUpdateDTO updateData) {
        var updateProduct = productRepository.findById(id).get();
        if(updateData.getCategoryId().isPresent() && categoryRepository.existsById(updateData.getCategoryId().get()))
        {
            updateProduct.setCategory(categoryRepository.findById(updateData.getCategoryId().get()).get());
            productMapper.update(updateData, updateProduct);
            productRepository.save(updateProduct);
            return ResponseEntity.ok(productMapper.map(updateProduct));
        } else return ResponseEntity.badRequest()
                .body(null);

    }
    // END
}
