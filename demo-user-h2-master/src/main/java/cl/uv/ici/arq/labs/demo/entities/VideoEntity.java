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
@Table(name = "VIDEO")
public class VideoEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private UUID  id;		

    @Column(name = "NOMBRE", nullable = false)
    private String name;


}