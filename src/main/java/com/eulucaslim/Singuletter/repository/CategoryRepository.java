package com.eulucaslim.Singuletter.repository;

import com.eulucaslim.Singuletter.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String name);

    boolean existsByName(String name);
}
