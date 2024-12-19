package model;

public class ItemTransaction {
    private int id;
    private String nama;
    private long subTotal;
    private int qty;

    public ItemTransaction(int id, String nama, long subTotal, int qty) {
        this.id = id;
        this.nama = nama;
        this.subTotal = subTotal;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
}
