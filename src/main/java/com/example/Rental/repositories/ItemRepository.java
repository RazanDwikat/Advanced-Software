package com.example.Rental.repositories;

import com.example.Rental.models.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByTitleContainingIgnoreCase(String title);
    boolean existsByCategoryId(Long categoryId);
    void deleteByCategoryId(Long categoryId);
}
