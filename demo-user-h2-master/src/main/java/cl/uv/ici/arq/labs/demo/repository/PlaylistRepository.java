package cl.uv.ici.arq.labs.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.uv.ici.arq.labs.demo.entities.UserEntity;


@Repository("playlistRepository")
public interface PlaylistRepository extends JpaRepository<UserEntity, UUID> {

    @Query(value = "SELECT * FROM PLAYLIST", nativeQuery = true)
    public List<UserEntity> getAll();
    
    @Query(value = "SELECT * FROM PLAYLIST WHERE videoId LIKE CONCAT('%',:id,'%')", nativeQuery = true)
    public List<UserEntity> findById(String id);

	public void addVideo(UUID fromString);

}
