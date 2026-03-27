package com.company.musicapp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    (message = "Name cannot be empty")
    private String name;

    public Long getId() { return id; }
    public String getName() { return name; }

}
