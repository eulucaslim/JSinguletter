package com.eulucaslim.Singuletter.controllers;


import com.eulucaslim.Singuletter.dto.requests.NewsRequestDTO;
import com.eulucaslim.Singuletter.dto.responses.NewsResponseDTO;
import com.eulucaslim.Singuletter.entity.News;
import com.eulucaslim.Singuletter.mappers.NewsMapper;
import com.eulucaslim.Singuletter.services.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService service;
    private final NewsMapper mapper;

    public NewsController(NewsService service, NewsMapper mapper) {
        this.service = service;
        this.mapper = mapper;
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

    @PostMapping
    public ResponseEntity<NewsResponseDTO> create(@RequestBody NewsRequestDTO newsDTO){
        News news = service.create(newsDTO);
        return new ResponseEntity<>(mapper.toDTO(news),HttpStatus.CREATED);
    }
}
