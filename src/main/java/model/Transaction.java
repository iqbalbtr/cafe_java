package model;

public class Transaction {

    private int id;
    private long total;
    private String pembeli;
    private String status;

    public Transaction(int id, long total, String pembeli, String status) {
        this.id = id;
        this.total = total;
        this.pembeli = pembeli;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getPembeli() {
        return pembeli;
    }

    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
