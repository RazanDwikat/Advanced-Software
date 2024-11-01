package com.example.Rental.models.Entity;

import com.example.Rental.models.Enumes.AvailabilityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Item entity representing an item available for rent in the rental system.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "price_per_day", nullable = false)
    private BigDecimal pricePerDay;

    private Boolean availability = true;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus itemStatus;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability_status", nullable = false)
    private AvailabilityStatus availabilityStatus = AvailabilityStatus.AVAILABLE;

    public boolean isAvailable() {
        return availability != null && availability;
    }


    private double averageRating;
    @Column(
            name = "review_count",
            nullable = false
    )
    private int reviewCount;

    public Item(Long itemId) {
        this.averageRating = 0.0;
        this.reviewCount = 0;
        this.id = itemId;
    }

}


