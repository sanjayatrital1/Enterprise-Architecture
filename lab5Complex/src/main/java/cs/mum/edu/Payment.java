package cs.mum.edu;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Payment {
    private String paydate;
    private double amount;

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\n Payment{" +
                "paydate='" + paydate + '\'' +
                ", amount=" + amount +
                '}';
    }
}
