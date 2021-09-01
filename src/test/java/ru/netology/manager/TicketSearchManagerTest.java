package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketSearchManagerTest {

    private TicketRepository repo = new TicketRepository();
    private TicketSearchManager manager = new TicketSearchManager(repo);

    Ticket one = new Ticket(1, 15500, "DXB", "SVO", 300);
    Ticket two = new Ticket(2, 2790, "LED", "SVO", 90);
    Ticket three = new Ticket(3, 2790, "LED", "SVO", 100);
    Ticket four = new Ticket(4, 12009, "AYT", "LED", 255);
    Ticket five = new Ticket(5, 9456, "AYT", "LED", 255);
    Ticket six = new Ticket(6, 4189, "DME", "KZN", 95);

    @BeforeEach
    void setUp() {
        repo.saveTicket(one);
        repo.saveTicket(two);
        repo.saveTicket(three);
        repo.saveTicket(four);
        repo.saveTicket(five);
        repo.saveTicket(six);
    }
    @Test
    void shouldFind() {
        Ticket[] actual = manager.findAll("DME", "KZN");
        Ticket[] expected = new Ticket[]{six};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindWhenParamsEqual() {
        Ticket[] actual = manager.findAll("AYT", "LED");
        Ticket[] expected = new Ticket[]{five, four};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAndSort() {
        Ticket[] actual = manager.findAll("LED", "SVO");
        Ticket[] expected = new Ticket[]{two, three};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnNull() {
        Ticket[] actual = manager.findAll("SVO", "KBD");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);
    }

}