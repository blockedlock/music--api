package com.company.musicapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    @Query("SELECT t FROM Track t JOIN PlaylistTrack pt ON t.id = pt.trackId WHERE pt.playlistId = :playlistId")
    List<Track> findTracksByPlaylistId(@Param("playlistId") Long playlistId);

}
