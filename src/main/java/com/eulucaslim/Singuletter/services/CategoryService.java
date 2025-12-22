package com.eulucaslim.Singuletter.services;

import com.eulucaslim.Singuletter.entity.Category;
import com.eulucaslim.Singuletter.exceptions.EntityAlreadyExists;
import com.eulucaslim.Singuletter.exceptions.NotFoundException;
import com.eulucaslim.Singuletter.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        List<Category> categories = repository.findAll();
        return categories;
    }

    public Category findById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category " + id + " Not Found!"));
        return category;
    }

    public Category getByName(String name) {
        Category category = repository.findByName(name);
        return category;
    }

    public boolean exists(String name) {
        return repository.existsByName(name);
    }

    public void create(String name) {
        if (repository.existsByName(name)) {
            throw new EntityAlreadyExists("This Category " + name + " already exists!");
        }
        repository.save(new Category(null, name, Instant.now()));
    }
}
