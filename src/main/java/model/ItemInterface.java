package model;

public abstract interface ItemInterface {

    public int getId();

    public void setId(int id);

    public String getNama();

    public void setNama(String nama);

    public String getJenis();

    public void setJenis(String jenis);

    public int getStock();

    public void setStock(int stock);

    public long getHarga();

    public void setHarga(long harga);
}
