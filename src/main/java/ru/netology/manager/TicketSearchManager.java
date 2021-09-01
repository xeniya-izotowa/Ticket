package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

@Data
@AllArgsConstructor
public class TicketSearchManager {
    private TicketRepository repository;

    public Ticket[] findAll(String from, String to) {
        Ticket[] tmp = new Ticket[0];
        for (Ticket t : repository.getAll()) {
            if (t.getDepartureFrom().equals(from) && t.getArrivalTo().equals(to)) {
                Ticket[] newTmp = new Ticket[tmp.length + 1];
                System.arraycopy(tmp, 0, newTmp, 0, tmp.length);
                newTmp[newTmp.length - 1] = t;
                tmp = newTmp;
            }
        }
        Arrays.sort(tmp);
        return tmp;
    }
}
