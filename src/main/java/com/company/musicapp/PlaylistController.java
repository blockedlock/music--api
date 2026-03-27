package com.company.musicapp;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {
    private final PlaylistService playlistService;


    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        return playlistService.deletePlaylist(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/playlists")
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }


    @GetMapping("/playlists/{id}/tracks")
    public List<Track> getTracksByPlaylist(@PathVariable Long id) {
        return playlistService.getTracksByPlaylist(id);
    }


    @PostMapping("/playlists")
    public Playlist addPlaylist(@Valid @RequestBody Playlist playlist) {
        return playlistService.addPlaylist(playlist);
    }

    @PostMapping("/playlists/{playlistId}/tracks/{trackId}")
    public void addTrackToPlaylist(@PathVariable Long playlistId, @PathVariable Long trackId) {
        playlistService.addTrackToPlaylist(playlistId, trackId);
    }


}
