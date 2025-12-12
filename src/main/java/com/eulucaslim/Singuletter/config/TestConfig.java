package com.eulucaslim.Singuletter.config;

import com.eulucaslim.Singuletter.entity.Category;
import com.eulucaslim.Singuletter.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("local")
public class TestConfig implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public TestConfig(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Tecnologia", Instant.now());
        List<Category> categories = categoryRepository.findByName(category1.getName());
        if (categories.isEmpty()) {
            categoryRepository.save(category1);
        }
    }
}
