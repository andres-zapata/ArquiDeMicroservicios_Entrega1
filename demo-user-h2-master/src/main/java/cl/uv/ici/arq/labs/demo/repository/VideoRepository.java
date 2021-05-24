package cl.uv.ici.arq.labs.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.uv.ici.arq.labs.demo.entities.VideoEntity;


@Repository("videoRepository")
public interface VideoRepository extends JpaRepository<VideoEntity, UUID> {

    @Query(value = "SELECT * FROM USUARIO", nativeQuery = true)
    public List<VideoEntity> getAll();
    
    @Query(value = "SELECT * FROM USUARIO WHERE APELLIDOS LIKE CONCAT('%',:lastName,'%')", nativeQuery = true)
    public List<VideoEntity> findByLastName(String lastName);

}