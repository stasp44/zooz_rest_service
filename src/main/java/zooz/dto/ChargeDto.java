package zooz.dto;


import java.io.Serializable;
import java.util.Date;

public class ChargeDto implements Serializable{
    private long amount;
    private long created;
    private String currency;
    private String customer;
    private String description;

    public long getAmount() {
        return amount;
    }

    public ChargeDto setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public long getCreated() {
        return created;
    }

    public ChargeDto setCreated(long created) {
        this.created = created;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public ChargeDto setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ChargeDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public ChargeDto setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public String toString() {
        return "ChargeDto{" +
                "amount=" + amount +
                ", created=" + created +
                ", currency='" + currency + '\'' +
                ", customer='" + customer + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
