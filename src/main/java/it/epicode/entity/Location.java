package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//AUTO INCREMENT
    private long id;
    private String nome;
    private String citta;

    @OneToMany (mappedBy = "location")
    private List<Evento> eventi;

}
