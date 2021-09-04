package ru.netology.domain;

import java.util.Comparator;

public class TicketComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        return t1.getFlightTime() - t2.getFlightTime();
    }

}
