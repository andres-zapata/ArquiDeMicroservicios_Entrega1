package cl.uv.ici.arq.labs.demo.entities;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import cl.uv.ici.arq.labs.demo.dtos.UserDTO;
import lombok.Data;

@Data
@Entity
@Table(name = "PERFIL")
public class PlaylistEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private UUID  playlistId;		

    @Column(name = "NOMBRES", nullable = false)
    private String name;

    @Column(name = "LISTA", nullable = false)
    private ArrayList<VideoEntity> videoList;

}