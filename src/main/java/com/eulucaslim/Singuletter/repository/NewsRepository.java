package com.eulucaslim.Singuletter.repository;

import com.eulucaslim.Singuletter.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NewsRepository extends JpaRepository<News, Long> {
}
