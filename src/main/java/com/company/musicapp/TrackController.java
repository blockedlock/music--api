package com.company.musicapp;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/tracks")
    public List<Track> getTracks() {
        return trackService.getAllTracks();
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Track> getTrack(@PathVariable Long id) {
        return trackService.getTrackById(id) != null
                ? ResponseEntity.ok(trackService.getTrackById(id))
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/tracks")
    public Track addTrack(@Valid @RequestBody Track track) {
        return trackService.addTrack(track);
    }

    @PutMapping("/tracks/{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable Long id, @RequestBody Track track) {
        Track updated = trackService.updateTrack(id, track);
        return updated != null
                ? ResponseEntity.ok(updated)
                : ResponseEntity.notFound().build();
    }


    @GetMapping("/tracks/search")
    public List<Track> searchByAuthor(@RequestParam String author) {
        return trackService.searchByAuthor(author);
    }

    @GetMapping("/tracks/search/length")
    public List<Track> searchByLength(@RequestParam double length) {
        return trackService.searchByLength(length);
    }

    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<Void> deleteTrack(@PathVariable Long id) {
        return trackService.deleteTrack(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/tracks/{id}/playlists")
    public List<Playlist> getPlaylistsByTrack(@PathVariable Long id) {
        return trackService.getPlaylistsByTrack(id);
    }

}
