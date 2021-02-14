package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "currency_inventory")
public class CurrencyInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_inventory_id")
    private int currencyInventoryId;

    @ManyToOne
    @JoinColumn(name = "current_daily_price_id")
    private CurrencyDailyPrice currencyDailyPrice;

    @Column(name = "old_price")
    private double oldPrice;

    @Column(name = "name_price")
    private double newPrice;

    private boolean isActive;

    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "updated_in")
    private Date updatedIn;

    public CurrencyInventory() {

    }

    public CurrencyInventory(int currencyInventoryId, CurrencyDailyPrice currencyDailyPrice, double oldPrice, double newPrice, boolean isActive, int staffId, Date updatedIn) {
        this.currencyInventoryId = currencyInventoryId;
        this.currencyDailyPrice = currencyDailyPrice;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.isActive = isActive;
        this.staffId = staffId;
        this.updatedIn = updatedIn;
    }

    public int getCurrencyInventoryId() {
        return currencyInventoryId;
    }

    public void setCurrencyInventoryId(int currencyInventoryId) {
        this.currencyInventoryId = currencyInventoryId;
    }

    public CurrencyDailyPrice getCurrencyDailyPrice() {
        return currencyDailyPrice;
    }

    public void setCurrencyDailyPrice(CurrencyDailyPrice currencyDailyPrice) {
        this.currencyDailyPrice = currencyDailyPrice;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public Date getUpdatedIn() {
        return updatedIn;
    }

    public void setUpdatedIn(Date updatedIn) {
        this.updatedIn = updatedIn;
    }

    @Override
    public String toString() {
        return "CurrencyInventory{" +
                "currencyInventoryId=" + currencyInventoryId +
                ", currencyDailyPrice=" + currencyDailyPrice +
                ", oldPrice=" + oldPrice +
                ", newPrice=" + newPrice +
                ", isActive=" + isActive +
                ", staffId=" + staffId +
                ", updatedIn=" + updatedIn +
                '}';
    }
}
