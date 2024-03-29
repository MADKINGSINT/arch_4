

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Система покупки билетов
 */
public class TiketProvider {
    private final Database database;
    private final PaymentProvider paymentProvider;

    public TiketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date) {
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date)) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    public boolean buyTicket(int clientId, String cardNo) {
        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketsAmount();
        return paymentProvider.buyTicket(orderId, cardNo, amount);
    }

    public boolean checkTicket(String qrcode) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setValid(false);
                // Save database
                return true;
            }
        }
        return false;
    }
}
