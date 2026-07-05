package galerilukisan;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GaleriBeraksi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=========================================");
        System.out.println(" SISTEM MANAJEMEN GALERI LUKISAN DIGITAL ");
        System.out.println("=========================================");
        System.out.println();
        
        // ========== ARRAY OBJECT ==========
        // 1. Tanya jumlah lukisan terlebih dahulu
        System.out.print("Masukkan jumlah data lukisan: ");
        int jumlahLukisan = 0;
        
        try {
            jumlahLukisan = scanner.nextInt();
            scanner.nextLine();
            
            if (jumlahLukisan <= 0) {
                throw new IllegalArgumentException("Jumlah harus lebih dari 0!");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Input harus berupa angka!");
            scanner.close();
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            scanner.close();
            return;
        }
        
        // 2. DEKLARASI ARRAY OBJECT dengan ukuran fixed
        LukisanDetail[] koleksiLukisan = new LukisanDetail[jumlahLukisan];
        
        // VARIABEL UNTUK KONTROL LOOP
        int nomorUrut = 1;
        int dataTersimpan = 0;
        
        // PERULANGAN UTAMA - menggunakan for loop (PERULANGAN)
        for (int i = 0; i < koleksiLukisan.length; i++) {
            System.out.println("\n--- Input Data Lukisan ke-" + (i + 1) + " ---");
            
            try {
                // INPUT DATA LUKISAN
                System.out.print("Masukkan Judul Lukisan: ");
                String judul = scanner.nextLine();
                
                if (judul.trim().isEmpty()) {
                    throw new IllegalArgumentException("Judul lukisan tidak boleh kosong!");
                }
                
                System.out.print("Masukkan Nama Pelukis: ");
                String pelukis = scanner.nextLine();
                
                if (pelukis.trim().isEmpty()) {
                    throw new IllegalArgumentException("Nama pelukis tidak boleh kosong!");
                }
                
                System.out.print("Masukkan Tahun Pembuatan (angka): ");
                int tahun = 0;
                try {
                    tahun = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (tahun < 1000 || tahun > 2026) {
                        throw new IllegalArgumentException("Tahun pembuatan tidak valid! (1000-2026)");
                    }
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    throw new InputMismatchException("Input tahun harus berupa angka!");
                }
                
                System.out.print("Masukkan Harga Lukisan (Rp): ");
                double harga = 0;
                try {
                    harga = scanner.nextDouble();
                    scanner.nextLine();
                    
                    if (harga < 0) {
                        throw new IllegalArgumentException("Harga tidak boleh negatif!");
                    }
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    throw new InputMismatchException("Input harga harus berupa angka!");
                }
                
                System.out.print("Masukkan Kode Lukisan (contoh: LKS-001): ");
                String kodeLukisan = scanner.nextLine();
                
                if (kodeLukisan.trim().isEmpty()) {
                    throw new IllegalArgumentException("Kode lukisan tidak boleh kosong!");
                }
                
                System.out.print("Masukkan Gaya Seni (contoh: Impresionisme, Kubisme, dll): ");
                String gayaSeni = scanner.nextLine();
                
                if (gayaSeni.trim().isEmpty()) {
                    throw new IllegalArgumentException("Gaya seni tidak boleh kosong!");
                }
                
                System.out.print("Apakah Lukisan Sudah Terjual? (true/false): ");
                boolean isTerjual = false;
                try {
                    isTerjual = scanner.nextBoolean();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    throw new InputMismatchException("Input harus true atau false!");
                }
                
                // 3. MEMBUAT OBJEK DAN MENYIMPAN KE ARRAY
                koleksiLukisan[i] = new LukisanDetail(judul, pelukis, tahun, harga, 
                                                       kodeLukisan, gayaSeni, isTerjual);
                dataTersimpan++;
                System.out.println("✓ Data lukisan berhasil disimpan!");
                
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("✗ ERROR: " + e.getMessage());
                System.out.println("Data lukisan ke-" + (i + 1) + " gagal disimpan.");
                i--; // ULANGI untuk indeks yang sama
            } catch (Exception e) {
                System.out.println("✗ ERROR tidak terduga: " + e.getMessage());
                i--;
            }
        }
        
        // ========== MENAMPILKAN DATA ==========
        System.out.println("\n=========================================");
        System.out.println("        DATA LUKISAN DALAM GALERI");
        System.out.println("=========================================");
        
        if (dataTersimpan == 0) {
            System.out.println("\nTidak ada data lukisan yang tersimpan.");
        } else {
            // PERULANGAN FOR untuk menampilkan data dari ARRAY
            int totalLukisan = 0;
            int totalTerjual = 0;
            double totalNilai = 0;
            
            for (int i = 0; i < koleksiLukisan.length; i++) {
                LukisanDetail lukisan = koleksiLukisan[i];
                
                if (lukisan != null) {
                    System.out.println("\n--- LUKISAN KE-" + (i + 1) + " ---");
                    System.out.println(lukisan.displayInfo());
                    
                    // Menampilkan informasi diskon
                    double diskon = lukisan.hitungDiskon();
                    System.out.printf("Diskon: Rp%,.2f\n", diskon);
                    System.out.printf("Harga Setelah Diskon: Rp%,.2f\n", lukisan.getHargaSetelahDiskon());
                    
                    // Overloading method
                    System.out.println("\n--- Informasi Tambahan ---");
                    String kategori = lukisan.getPeriode();
                    System.out.println(lukisan.displayInfo(kategori));
                    
                    totalLukisan++;
                    if (lukisan.getIsTerjual()) {
                        totalTerjual++;
                    }
                    totalNilai += lukisan.getHarga();
                }
            }
            
            // MENAMPILKAN RINGKASAN
            System.out.println("\n=========================================");
            System.out.println("            RINGKASAN GALERI");
            System.out.println("=========================================");
            System.out.println("Total Lukisan: " + totalLukisan);
            System.out.println("Lukisan Terjual: " + totalTerjual);
            System.out.println("Lukisan Tersedia: " + (totalLukisan - totalTerjual));
            System.out.printf("Total Nilai Koleksi: Rp%,.2f\n", totalNilai);
            
            // MENAMPILKAN LUKISAN TERSEDIA
            System.out.println("\n=========================================");
            System.out.println("      DAFTAR LUKISAN TERSEDIA");
            System.out.println("=========================================");
            boolean adaTersedia = false;
            for (int i = 0; i < koleksiLukisan.length; i++) {
                LukisanDetail lukisan = koleksiLukisan[i];
                if (lukisan != null && !lukisan.getIsTerjual()) {
                    System.out.println("- " + lukisan.getJudul() + 
                                       " (Rp" + String.format("%,.2f", lukisan.getHarga()) + ")");
                    adaTersedia = true;
                }
            }
            if (!adaTersedia) {
                System.out.println("Tidak ada lukisan yang tersedia saat ini.");
            }
        }
        
        System.out.println("\n=========================================");
        System.out.println("  Terima kasih telah menggunakan sistem!");
        System.out.println("=========================================");
        
        scanner.close();
    }
}