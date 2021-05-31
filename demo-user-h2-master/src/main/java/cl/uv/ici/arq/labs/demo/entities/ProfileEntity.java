package cl.uv.ici.arq.labs.demo.entities;

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
public class ProfileEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private UUID  profileId;		

    @Column(name = "NOMBRES", nullable = false)
    private String name;

    @Column(name = "USUARIO", nullable = false)
    private String userId ;

//    @Column(name = "LISTA", nullable = false)
//    private ListEntity listaReproduccion;

}