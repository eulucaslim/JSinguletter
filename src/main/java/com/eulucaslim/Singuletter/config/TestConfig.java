package com.eulucaslim.Singuletter.config;

import com.eulucaslim.Singuletter.entity.Category;
import com.eulucaslim.Singuletter.entity.News;
import com.eulucaslim.Singuletter.entity.User;
import com.eulucaslim.Singuletter.repository.CategoryRepository;
import com.eulucaslim.Singuletter.repository.NewsRepository;
import com.eulucaslim.Singuletter.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("local")
public class TestConfig implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final NewsRepository newsRepository;
    private final UserService userService;


    public TestConfig(CategoryRepository categoryRepository, NewsRepository newsRepository, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.newsRepository = newsRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "admin", "admin@admin.com", "admin1234");
        userService.create(user1);

        Category cat1 = new Category(
                null,
                "Tecnologia Nova",
                Instant.parse("2019-06-20T19:53:07Z")
        );
        Category cat2 = new Category(
                null,
                "Inteligencia artificial",
                Instant.parse("2019-06-20T19:53:07Z")
        );

        for (Category cat: Arrays.asList(cat1, cat2)) {
            if (!categoryRepository.existsByName(cat.getName())) {
                categoryRepository.save(cat);
            }
        }

        News new1 = new News(
                null,
                "O uso da Ia",
                "A utilizacao da IA vem crescendo a muito tempo",
                cat2,
                Instant.parse("2019-06-20T19:53:07Z")
        );

        News new2 = new News(
                null,
                "Docker container",
                "A utilizacao da dockerizacao das aplicacoes",
                cat1,
                Instant.parse("2019-06-20T19:53:07Z")
        );

        for (News newsObj: Arrays.asList(new1, new2)) {
            if (!newsRepository.existsByTitle(newsObj.getTitle())){
                newsRepository.save(newsObj);
            }
        }
        System.out.println("OK!");
    }
}
