package com.company.musicapp;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Track getTrackById(Long id) {
        return trackRepository.findById(id).orElse(null);
    }

    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }

    public Track updateTrack(Long id, Track track) {
        if (!trackRepository.existsById(id)) {
            return null;
        }
        track.setId(id);
        return trackRepository.save(track);
    }


    public List<Track> searchByAuthor(String author) {
        return trackRepository.findByAuthor(author);
    }

    public List<Track> searchByLength(double length) {
        return trackRepository.findByLengthGreaterThan(length);
    }

    public boolean deleteTrack(Long id) {
        if (trackRepository.existsById(id)) {
            trackRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Playlist> getPlaylistsByTrack(Long trackId) {
        return trackRepository.findPlaylistsByTrackId(trackId);
    }

}
