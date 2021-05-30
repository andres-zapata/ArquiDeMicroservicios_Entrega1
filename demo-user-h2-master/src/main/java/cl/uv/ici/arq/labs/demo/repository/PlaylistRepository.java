package cl.uv.ici.arq.labs.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.uv.ici.arq.labs.demo.entities.PlaylistEntity;


@Repository("playlistRepository")
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, UUID> {

    @Query(value = "SELECT * FROM PLAYLIST", nativeQuery = true)
    public List<PlaylistEntity> getAll();
    
    @Query(value = "SELECT * FROM PLAYLIST WHERE videoId LIKE CONCAT('%',:id,'%')", nativeQuery = true)
    public List<PlaylistEntity> findById(String id);

    @Query(value = "INSERT INTO PLAYLIST (LISTA) VALUES (videoId) WHERE PLAYLIST.playlistId = playListId", nativeQuery = true)
    public List<PlaylistEntity> addVideo(String playListId, String videoId);

}
