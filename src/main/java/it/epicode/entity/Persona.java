package it.epicode.entity;

import it.epicode.enums.Sesso;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//AUTO INCREMENT
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private Sesso sesso;

    @OneToMany (mappedBy = "persona")
    private List<Partecipazione> partecipazioni = new ArrayList<>();

}
