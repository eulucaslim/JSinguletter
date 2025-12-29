package com.eulucaslim.Singuletter.services;

import com.eulucaslim.Singuletter.dto.requests.NewsRequestDTO;
import com.eulucaslim.Singuletter.entity.Category;
import com.eulucaslim.Singuletter.entity.News;
import com.eulucaslim.Singuletter.exceptions.NotFoundException;
import com.eulucaslim.Singuletter.mappers.NewsMapper;
import com.eulucaslim.Singuletter.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository repository;
    private final NewsMapper mapper;
    private final CategoryService categoryService;


    public NewsService(NewsRepository repository, NewsMapper mapper, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<News> findAll(){
        List<News> news = repository.findAll();
        return news;
    }

    public News findById(Long id) {
        News news = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("News " + id + " Not Found!"));
        return news;
    }

    public News create(NewsRequestDTO newsDTO) {
        if (!categoryService.exists(newsDTO.categoryName())) {
            categoryService.create(newsDTO.categoryName());
        }
        Category category = categoryService.getByName(newsDTO.categoryName());
        News news = mapper.toEntity(newsDTO);
        news.setCategory(category);
        return repository.save(news);
    }
}
