package cl.uv.ici.arq.labs.demo.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USUARIO")
public class UserEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private UUID  userId;		

    @Column(name = "NOMBRES", nullable = false)
    private String firstName;

    @Column(name = "APELLIDOS", nullable = false)
    private String lastName;

}