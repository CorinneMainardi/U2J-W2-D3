package it.epicode;
import it.epicode.dao.EventoDAO;
import it.epicode.entity.Evento;
import it.epicode.entity.Location;
import it.epicode.enums.TipoEvento;
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

        Evento evento = new Evento();
        Location location = new Location();
        EventoDAO ed = new EventoDAO(em);
        List<Evento> eventi = new ArrayList<>();
        eventi.add(evento);

        evento.setDataEvento(LocalDate.of(2024,12,11));
        evento.setTipoEvento(TipoEvento.PRIVATO);
        evento.setTitolo("Concerto imagine dragons");
        evento.setDescrizione("concerto all'aperto");
        evento.setLocation(location);

        location.setCitta("Roma");
        location.setNome("Olimpico");
        location.setEventi(eventi);

        ed.saveEventoLocation(evento, location);

        em.close();
        emf.close();


    }
}
