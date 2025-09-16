package com.ayurveda.diet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {
    @Id
    @GeneratedValue
    @Column(name = "recipe_id", updatable = false, nullable = false)
    private UUID recipeId;

    private String name;
    private String description;
    private String ayurvedaNotes;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
}
