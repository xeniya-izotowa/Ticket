package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket implements  Comparable<Ticket> {
    private int id;
    private int price;
    private String departureFrom;
    private String arrivalTo;
    private int flightTime;


    @Override
    public int compareTo(Ticket o) {
        return this.price - o.getPrice();
    }
}
