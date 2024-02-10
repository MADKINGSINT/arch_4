

import java.util.Collection;
import java.util.Date;

/**
 * Мобильное приложение
 */
public class MobileApp {
    private final Customer customer;
    private final TiketProvider tiketProvider;
    private final CustomerProvider customerProvider;

    public MobileApp(TiketProvider tiketProvider, CustomerProvider customerProvider) {
        this.tiketProvider = tiketProvider;
        this.customerProvider = customerProvider;
        customer = customerProvider.getCustomer("<login>", "<password>");
    }

    public Collection<Ticket> getTickets() {
        return customer.getTickets();
    }

    public void searchTicket(Date date) {
        customer.setTickets(tiketProvider.searchTicket(customer.getId(), new Date()));
    }

    public boolean buyTicket(String cardNo) {
        return tiketProvider.buyTicket(customer.getId(), cardNo);
    }
}
