import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("Томск", "Сочи", 16_900, 9, 24);
    Ticket ticket2 = new Ticket("Москва", "Сочи", 7_000, 7, 12);
    Ticket ticket3 = new Ticket("Новосибирск", "Сочи", 12_166, 12, 20);
    Ticket ticket4 = new Ticket("Москва", "Сочи", 14_080, 17, 24);
    Ticket ticket5 = new Ticket("Томск", "Сочи", 12_818, 16, 24);
    Ticket ticket6 = new Ticket("Москва", "Сочи", 24_080, 6, 8);
    Ticket ticket7 = new Ticket("Москва", "Сочи", 10_000, 2, 16);
    Ticket ticket8 = new Ticket("Москва", "Сочи", 11_900, 20, 24);
    Ticket ticket9 = new Ticket("Москва", "Сочи", 8_100, 3, 6);
    Ticket ticket10 = new Ticket("Москва", "Сочи", 17_300, 18, 24);

    @Test
    public void inDecreasingOrderPriceAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket2, ticket9, ticket7, ticket8, ticket3, ticket5, ticket4, ticket1, ticket10, ticket6};
        Ticket[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inDecreasingOrderPriceTomsk() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket5, ticket1};
        Ticket[] actual = manager.search("Томск", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inDecreasingOrderPriceMoscow() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket2, ticket9, ticket7, ticket8, ticket4, ticket10, ticket6};
        Ticket[] actual = manager.search("Москва", "Сочи");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inDecreasingOrderPriceNothingToWear() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Сочи", "Москва");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inDecreasingOrderTimeAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket>comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket6, ticket9, ticket8, ticket2, ticket10, ticket4, ticket3, ticket5, ticket7, ticket1};
        Ticket[] actual = manager.findAll(comparator);

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void inDecreasingOrderTimeTomsk() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket>comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket1};
        Ticket[] actual = manager.searchAndSortBy("Томск", "Сочи",comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inDecreasingOrderTimeMoscow() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket>comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6, ticket9, ticket8, ticket2, ticket10, ticket4, ticket7};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Сочи", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inDecreasingOrderTimeNothingToWear() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Сочи", "Москва", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}

