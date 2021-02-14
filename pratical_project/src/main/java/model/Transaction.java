package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet walletId;

    @Column(name = "wallet_sum")
    private int walletSum;

    @Column(name = "status")
    private String status;

    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "wallet_order_total")
    private double walletOrderTotal;

    @Column(name = "date_register")
    private Date dateRegister;

    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    public Transaction() {
    }

    public Transaction(int transactionId, Wallet walletId, int walletSum, String status, int staffId, double walletOrderTotal, Date dateRegister, PaymentType paymentType) {
        this.transactionId = transactionId;
        this.walletId = walletId;
        this.walletSum = walletSum;
        this.status = status;
        this.staffId = staffId;
        this.walletOrderTotal = walletOrderTotal;
        this.dateRegister = dateRegister;
        this.paymentType = paymentType;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Wallet getWalletId() {
        return walletId;
    }

    public void setWalletId(Wallet walletId) {
        this.walletId = walletId;
    }

    public int getWalletSum() {
        return walletSum;
    }

    public void setWalletSum(int walletSum) {
        this.walletSum = walletSum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public double getWalletOrderTotal() {
        return walletOrderTotal;
    }

    public void setWalletOrderTotal(double walletOrderTotal) {
        this.walletOrderTotal = walletOrderTotal;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", walletId=" + walletId +
                ", walletSum=" + walletSum +
                ", status='" + status + '\'' +
                ", staffId=" + staffId +
                ", walletOrderTotal=" + walletOrderTotal +
                ", dateRegister=" + dateRegister +
                ", paymentType=" + paymentType +
                '}';
    }
}