

/**
 * Автобусная станция
 */
public class BusStation {
    private final TiketProvider tiketProvider;

    public BusStation(TiketProvider tiketProvider) {
        this.tiketProvider = tiketProvider;
    }

    public boolean checkTicket(String qrCode) {
        return tiketProvider.checkTicket(qrCode);
    }
}
