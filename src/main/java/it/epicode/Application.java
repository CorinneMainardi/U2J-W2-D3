package it.epicode;
import it.epicode.dao.EventoDAO;
import it.epicode.entity.Evento;
import it.epicode.entity.Location;
import it.epicode.enums.TipoEvento;
import it.epicode.runner.Runner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
        EntityManager em = emf.createEntityManager();

        Runner.run(em);



        em.close();
        emf.close();


    }
}
