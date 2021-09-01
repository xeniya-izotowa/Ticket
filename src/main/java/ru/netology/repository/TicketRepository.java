package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;

@NoArgsConstructor
public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] getAll() {
        return tickets;
    }

    public void saveTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket t : tickets) {
            if (t.getId() != id) {
                tmp[index] = tickets[index];
                index++;
            }
        }
        tickets = tmp;
    }
}
