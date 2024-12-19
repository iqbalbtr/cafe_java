package model;


public class ItemCart extends Item {
    
    private int qty;
    private long subTotal;

    public ItemCart(int id, String nama, String jenis, int stock, long harga, int qty, long subTotal) {
        super(id, nama, jenis, stock, harga);
        this.qty = qty;
        this.subTotal = subTotal;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }
    
}
