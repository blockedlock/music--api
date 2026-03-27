package com.company.musicapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PlaylistTrackRepository extends JpaRepository<PlaylistTrack, Long> {
    @Transactional
    void deleteByPlaylistIdAndTrackId(Long playlistId, Long trackId);


}
