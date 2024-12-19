package model;

public class Item implements ItemInterface{
    private int id;
    private String nama;
    private String jenis;
    private int stock;
    private long harga;

    public Item(int id, String nama, String jenis, int stock, long harga) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.stock = stock;
        this.harga = harga;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public long getHarga() { return harga; }
    public void setHarga(long harga) { this.harga = harga; }
}
