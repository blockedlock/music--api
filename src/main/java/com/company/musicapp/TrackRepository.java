package com.company.musicapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findByAuthor(String author);
    List<Track> findByLengthGreaterThan(double length);
    @Query("SELECT p FROM Playlist p JOIN PlaylistTrack pt ON p.id = pt.playlistId WHERE pt.trackId = :trackId")
    List<Playlist> findPlaylistsByTrackId(@Param("trackId") Long trackId);




}
