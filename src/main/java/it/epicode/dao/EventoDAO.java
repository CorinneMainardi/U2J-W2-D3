package it.epicode.dao;

import it.epicode.entity.Evento;
import it.epicode.entity.Location;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento e){
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit(); //invio il tutto al database manon è chiuso. la chiusura nwel main
    }

    public void insertAll(List<Evento> lista) {
        em.getTransaction().begin();
        for (Evento e : lista) {
            em.persist(e);//persist sul singolo evento è come fosse save all
        }
        em.getTransaction().commit();
    }

    public Evento findEventoById(Long id) {
        return em.find(Evento.class, id); //per cercare evento lato front end
    }

    public void delete(Evento e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

}