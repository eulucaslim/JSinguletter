package com.eulucaslim.Singuletter.mappers;

import com.eulucaslim.Singuletter.dto.requests.NewsRequestDTO;
import com.eulucaslim.Singuletter.dto.responses.NewsResponseDTO;
import com.eulucaslim.Singuletter.entity.News;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class NewsMapper {

    public NewsResponseDTO toDTO(News news){
        NewsResponseDTO dto = new NewsResponseDTO(
                news.getId(),
                news.getTitle(),
                news.getContent(),
                news.getCategory(),
                news.getCreatedAt()
        );
        return dto;
    }

    public News toEntity(NewsRequestDTO dto){
        News news = new News();
        news.setId(null);
        news.setTitle(dto.title());
        news.setContent(dto.content());
        news.setCreatedAt(Instant.now());
        return news;
    }
}
