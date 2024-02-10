

import java.util.Collection;
import java.util.Date;

/**
 * Разработать контракты и компаненты системы "Покупка онлайн билетов на автобус
 * в час пик"
 * 
 * 1. Предусловие 2. Постусловие 3. Инвариант 4. Определить абстрактные и
 * конкретные классы 5. Определить интерфейсы. 6. Реализовать наследование 7.
 * Выявить компаненты 8. Разработать Диаграмму компанент используя нотации UML
 * 2.0 Общая без деталей
 */
public class Program {
    public static void main(String[] args) {
        Core core = new Core();
        MobileApp app = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());

        if (app.buyTicket("11000000221")) {
            System.out.println("Клиент успешно купил билет");
            app.searchTicket(new Date());
            Collection<Ticket> tickets = app.getTickets();
            if (busStation.checkTicket(tickets.stream().findFirst().get().getQrcode())) {
                System.out.println("Клиент успешно прошёл в автобус");
            }
        }
    }
}