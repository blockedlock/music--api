package com.company.musicapp;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @Positive(message = "Length must be positive")
    private double length;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAuthor() { return author; }
    public double getLength() { return length; }
    public void setId(Long id) { this.id = id; }
}
