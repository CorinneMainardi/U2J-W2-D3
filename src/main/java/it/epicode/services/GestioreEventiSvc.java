package it.epicode.services;

import it.epicode.entity.Evento;
import it.epicode.entity.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class GestioreEventiSvc {
    private EntityManager em;

    public GestioreEventiSvc(EntityManager em) {
        this.em = em;
    }
    public void saveEventoLocation(Evento e, Location l){
        //metodo per salvarle in relazione
        em.getTransaction().begin();
        l.getEventi().add(e); //in location c'è una lista di eventi e lo abbiamo preso in location
        em.persist(e);
        em.persist(l);
        em.getTransaction().commit();
    }
}
