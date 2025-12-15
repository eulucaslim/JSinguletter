package com.eulucaslim.Singuletter.controllers;


import com.eulucaslim.Singuletter.entity.News;
import com.eulucaslim.Singuletter.services.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService service;

    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        List<News> news = service.findAll();
        if (news.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(news);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> findById(@PathVariable Long id) {
        News news = service.findById(id);
        return ResponseEntity.ok().body(news);
    }
}
