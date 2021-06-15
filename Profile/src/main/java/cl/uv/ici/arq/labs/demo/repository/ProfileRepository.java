package cl.uv.ici.arq.labs.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.uv.ici.arq.labs.demo.entities.ProfileEntity;


@Repository("profileRepository")
public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {

}