package org.example.pawpal_project.repository;

import org.example.pawpal_project.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article findById(Long id);
}
