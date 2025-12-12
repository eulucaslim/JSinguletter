package com.eulucaslim.Singuletter.repository;

import com.eulucaslim.Singuletter.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String name);
}
