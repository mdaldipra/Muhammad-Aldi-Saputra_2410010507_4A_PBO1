package galerilukisan;

public class LukisanDetail extends Lukisan {
    // Atribut tambahan
    private String kodeLukisan;
    private String gayaSeni;
    private boolean isTerjual;
    
    // CONSTRUCTOR
    public LukisanDetail(String judul, String pelukis, int tahun, double harga, 
                         String kodeLukisan, String gayaSeni, boolean isTerjual) {
        // Memanggil constructor superclass
        super(judul, pelukis, tahun, harga);
        this.kodeLukisan = kodeLukisan;
        this.gayaSeni = gayaSeni;
        this.isTerjual = isTerjual;
    }
    
    // MUTATOR tambahan
    public void setKodeLukisan(String kodeLukisan) {
        this.kodeLukisan = kodeLukisan;
    }
    
    public void setGayaSeni(String gayaSeni) {
        this.gayaSeni = gayaSeni;
    }
    
    public void setIsTerjual(boolean isTerjual) {
        this.isTerjual = isTerjual;
    }
    
    // ACCESSOR tambahan
    public String getKodeLukisan() {
        return kodeLukisan;
    }
    
    public String getGayaSeni() {
        return gayaSeni;
    }
    
    public boolean getIsTerjual() {
        return isTerjual;
    }
    
    // Method untuk mendapatkan periode berdasarkan tahun (Seleksi)
    public String getPeriode() {
        int tahun = getTahun();
        if (tahun < 1800) {
            return "Pra-Modern";
        } else if (tahun >= 1800 && tahun < 1900) {
            return "Modern Awal";
        } else if (tahun >= 1900 && tahun < 1960) {
            return "Modern";
        } else if (tahun >= 1960 && tahun < 2000) {
            return "Kontemporer";
        } else {
            return "Kontemporer Akhir";
        }
    }
    
    // Method untuk mendapatkan status keterjualan dalam bentuk teks (Seleksi)
    public String getStatusTerjual() {
        if (isTerjual) {
            return "TERJUAL";
        } else {
            return "TERSEDIA";
        }
    }
    
    // OVERRIDING - Menimpa method displayInfo dari superclass
    @Override
    public String displayInfo() {
        return super.displayInfo() + 
               "\nKode Lukisan: " + kodeLukisan + 
               "\nGaya Seni: " + gayaSeni + 
               "\nStatus: " + getStatusTerjual() +
               "\nPeriode: " + getPeriode();
    }
    
    // OVERRIDING - Menimpa method hitungDiskon dari superclass
    @Override
    public double hitungDiskon() {
        double diskonDasar = super.hitungDiskon();
        // Diskon tambahan jika lukisan sudah lama (seleksi)
        int tahunSekarang = 2026;
        int usiaLukisan = tahunSekarang - getTahun();
        
        if (usiaLukisan > 100) {
            // Lukisan antik mendapat diskon tambahan 10%
            return diskonDasar + (getHarga() * 0.10);
        } else if (usiaLukisan > 50) {
            // Lukisan klasik mendapat diskon tambahan 5%
            return diskonDasar + (getHarga() * 0.05);
        } else {
            return diskonDasar;
        }
    }
    
    // Method untuk menghitung harga setelah diskon
    public double getHargaSetelahDiskon() {
        return getHarga() - hitungDiskon();
    }
}