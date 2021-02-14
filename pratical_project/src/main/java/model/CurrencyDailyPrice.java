package model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "currency_daily_price")
public class CurrencyDailyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "current_daily_price_id")
    private int id;

    @Column(name = "price_date")
    private Date priceDate;

    @Column(name = "price")
    private double price;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "last_update")
    private Date lastUpdate;

    @Column(name = "amount_available")
    private double amountAvailable;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public CurrencyDailyPrice() {
    }

    public CurrencyDailyPrice(int id, Date priceDate, double price, Date registerDate, Date lastUpdate, double amountAvailable) {
        this.id = id;
        this.priceDate = priceDate;
        this.price = price;
        this.registerDate = registerDate;
        this.lastUpdate = lastUpdate;
        this.amountAvailable = amountAvailable;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public double getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(double amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    @Override
    public String toString() {
        return "CurrencyDailyPrice{" +
                "id=" + id +
                ", priceDate=" + priceDate +
                ", price=" + price +
                ", registerDate=" + registerDate +
                ", lastUpdate=" + lastUpdate +
                ", amountAvailable=" + amountAvailable +
                '}';
    }
}
