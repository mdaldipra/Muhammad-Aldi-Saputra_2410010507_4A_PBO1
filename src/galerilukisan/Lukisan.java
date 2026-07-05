package galerilukisan;

public class Lukisan {
    // ATRIBUT (Encapsulation - Private)
    private String judul;
    private String pelukis;
    private int tahun;
    private double harga;
    
    // CONSTRUCTOR
    public Lukisan(String judul, String pelukis, int tahun, double harga) {
        this.judul = judul;
        this.pelukis = pelukis;
        this.tahun = tahun;
        this.harga = harga;
    }
    
    // MUTATOR (Setter)
    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public void setPelukis(String pelukis) {
        this.pelukis = pelukis;
    }
    
    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
    
    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    // ACCESSOR (Getter)
    public String getJudul() {
        return judul;
    }
    
    public String getPelukis() {
        return pelukis;
    }
    
    public int getTahun() {
        return tahun;
    }
    
    public double getHarga() {
        return harga;
    }
    
    // METHOD untuk menampilkan info (akan di-override)
    public String displayInfo() {
        return "Judul: " + judul + 
               "\nPelukis: " + pelukis + 
               "\nTahun: " + tahun + 
               "\nHarga: Rp" + String.format("%,.2f", harga);
    }
    
    // OVERLOADING - displayInfo dengan parameter tambahan
    public String displayInfo(String kategori) {
        return displayInfo() + "\nKategori: " + kategori;
    }
    
    // Method untuk menghitung diskon (akan di-override)
    public double hitungDiskon() {
        // Diskon dasar 5% untuk semua lukisan
        return harga * 0.05;
    }
}
