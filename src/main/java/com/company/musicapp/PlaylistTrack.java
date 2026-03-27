package com.company.musicapp;


import jakarta.persistence.*;

@Entity
@Table(name = "playlist_tracks")
public class PlaylistTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playlistId;
    private Long trackId;

    public Long getPlaylistId() { return playlistId; }
    public Long getTrackId() { return trackId; }

    public void setPlaylistId(Long playlistId) { this.playlistId = playlistId; }
    public void setTrackId(Long trackId) { this.trackId = trackId; }

}
