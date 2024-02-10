

import java.sql.Date;

/**
 * Класс описывает билет
 */
public class Ticket {
    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean isValid = true;

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isValid() {
        return isValid;
    }

}
