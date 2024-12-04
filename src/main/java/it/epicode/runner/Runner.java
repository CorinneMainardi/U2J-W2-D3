package it.epicode.runner;

import it.epicode.dao.EventoDAO;
import it.epicode.entity.Evento;
import it.epicode.entity.Location;
import it.epicode.enums.TipoEvento;
import it.epicode.services.GestioreEventiSvc;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void run(EntityManager em) {
        Evento evento = new Evento();
        Location location = new Location();
        GestioreEventiSvc ed = new GestioreEventiSvc(em);
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
    }
}
