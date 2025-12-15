package com.eulucaslim.Singuletter.services;

import com.eulucaslim.Singuletter.entity.News;
import com.eulucaslim.Singuletter.exceptions.NotFoundException;
import com.eulucaslim.Singuletter.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository repository;

    public NewsService(NewsRepository repository) {
        this.repository = repository;
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
}
