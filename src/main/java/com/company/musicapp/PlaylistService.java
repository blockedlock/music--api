package com.company.musicapp;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final PlaylistTrackRepository playlistTrackRepository;

    public PlaylistService(PlaylistRepository playlistRepository, PlaylistTrackRepository playlistTrackRepository) {
        this.playlistRepository = playlistRepository;
        this.playlistTrackRepository = playlistTrackRepository;
    }

    public List<Track> getTracksByPlaylist(Long playlistId) {
        return playlistRepository.findTracksByPlaylistId(playlistId);
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist addPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public boolean deletePlaylist(Long id) {
        if (playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void addTrackToPlaylist(Long playlistId, Long trackId) {
        PlaylistTrack pt = new PlaylistTrack();
        pt.setPlaylistId(playlistId);
        pt.setTrackId(trackId);
        playlistTrackRepository.save(pt);
    }
}
