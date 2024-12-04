package it.epicode.entity;

import it.epicode.enums.Stato;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // AUTO INCREMENT
    private long id;

    @ManyToOne // Una partecipazione è associata a una sola persona
    private Persona persona;

    @ManyToOne // Una partecipazione è associata a un solo evento
    private Evento evento;

    @Enumerated(EnumType.STRING) // Mappa l'enum come stringa nel database
    @Column(nullable = false)
    private Stato stato;
}
