

/**
 * Класс объеденяющий все сервисы(ядро приложения)
 */
public class Core {
    private final CustomerProvider customerProvider;
    private final TiketProvider tiketProvider;
    private final PaymentProvider paymentProvider;
    private final Database database;

    public Core() {
        database = new Database();
        customerProvider = new CustomerProvider(database);
        paymentProvider = new PaymentProvider();
        tiketProvider = new TiketProvider(database, paymentProvider);
    }

    public TiketProvider getTicketProvider() {
        return tiketProvider;
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }
}
