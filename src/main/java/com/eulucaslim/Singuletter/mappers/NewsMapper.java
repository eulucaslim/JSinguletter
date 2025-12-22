package com.eulucaslim.Singuletter.mappers;

import com.eulucaslim.Singuletter.dto.NewsDTO;
import com.eulucaslim.Singuletter.dto.UserDTO;
import com.eulucaslim.Singuletter.entity.News;
import com.eulucaslim.Singuletter.entity.User;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper {

    public NewsDTO toDTO(News news){
        NewsDTO dto = new NewsDTO(news.getId(), news.getTitle(), news.getContent(), news.getCategory().getName());
        return dto;
    }

    public News toEntity(NewsDTO dto){
        News news = new News();
        news.setId(null);
        news.setTitle(dto.title());
        news.setContent(dto.content());
        return news;
    }
}
