package com.teju.team4.repository;



import com.teju.team4.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categoryrepository extends JpaRepository<Category, Long> {
    // You can define custom query methods here if needed
}
