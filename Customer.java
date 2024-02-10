

import java.util.Collection;

/**
 * Класс описывает покупателя
 */
public class Customer {
    private static int counter;
    private final int id;
    private Collection<Ticket> tickets;
    {
        id = ++counter;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

}
