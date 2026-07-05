# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi sistem manajemen galeri lukisan digital menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa data lukisan (judul, pelukis, tahun, harga, kode lukisan, gaya seni, dan status terjual), dan memberikan output berupa informasi detail dari setiap lukisan seperti periode seni, status ketersediaan, perhitungan diskon berdasarkan usia lukisan, dan harga setelah diskon.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Lukisan`, `LukisanDetail`, dan `GaleriBeraksi` adalah contoh dari class.

```bash
public class Lukisan {
    ...
}

public class LukisanDetail extends Lukisan {
    ...
}

public class GaleriBeraksi {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `new LukisanDetail(judul, pelukis, tahun, harga, kodeLukisan, gayaSeni, isTerjual);` adalah contoh pembuatan object.

```bash
koleksiLukisan[i] = new LukisanDetail(judul, pelukis, tahun, harga, 
                                       kodeLukisan, gayaSeni, isTerjual);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `judul`, `pelukis`, `tahun`, `harga`, `kodeLukisan`, `gayaSeni`, dan `isTerjual` adalah contoh atribut.

```bash
private String judul;
private String pelukis;
private int tahun;
private double harga;
private String kodeLukisan;
private String gayaSeni;
private boolean isTerjual;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Lukisan` dan `LukisanDetail`.

```bash
public Lukisan(String judul, String pelukis, int tahun, double harga) {
    this.judul = judul;
    this.pelukis = pelukis;
    this.tahun = tahun;
    this.harga = harga;
}

public LukisanDetail(String judul, String pelukis, int tahun, double harga, 
                     String kodeLukisan, String gayaSeni, boolean isTerjual) {
    super(judul, pelukis, tahun, harga);
    this.kodeLukisan = kodeLukisan;
    this.gayaSeni = gayaSeni;
    this.isTerjual = isTerjual;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setJudul`, `setPelukis`, `setTahun`, `setHarga`, `setKodeLukisan`, `setGayaSeni`, dan `setIsTerjual` adalah contoh method mutator.

```bash
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

public void setKodeLukisan(String kodeLukisan) {
    this.kodeLukisan = kodeLukisan;
}

public void setGayaSeni(String gayaSeni) {
    this.gayaSeni = gayaSeni;
}

public void setIsTerjual(boolean isTerjual) {
    this.isTerjual = isTerjual;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getJudul`, `getPelukis`, `getTahun`, `getHarga`, `getKodeLukisan`, `getGayaSeni`, dan `getIsTerjual` adalah contoh method accessor.

```bash
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

public String getKodeLukisan() {
    return kodeLukisan;
}

public String getGayaSeni() {
    return gayaSeni;
}

public boolean getIsTerjual() {
    return isTerjual;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, semua atribut dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private String judul;
private String pelukis;
private int tahun;
private double harga;
private String kodeLukisan;
private String gayaSeni;
private boolean isTerjual;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `LukisanDetail` mewarisi `Lukisan` dengan sintaks `extends`.

```bash
public class LukisanDetail extends Lukisan {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `displayInfo(String)` di `Lukisan` merupakan overloading method `displayInfo` dan `displayInfo` di `LukisanDetail` merupakan override dari method `displayInfo` di `Lukisan`. Begitu pula dengan method `hitungDiskon` yang di-override di `LukisanDetail`.

```bash
// OVERLOADING
public String displayInfo() {
    return "Judul: " + judul + ...
}

public String displayInfo(String kategori) {
    return displayInfo() + "\nKategori: " + kategori;
}

// OVERRIDING
@Override
public String displayInfo() {
    return super.displayInfo() + 
           "\nKode Lukisan: " + kodeLukisan + ...
}

@Override
public double hitungDiskon() {
    double diskonDasar = super.hitungDiskon();
    ...
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `getPeriode`, `getStatusTerjual`, dan `hitungDiskon`.

```bash
public String getPeriode() {
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

public String getStatusTerjual() {
    if (isTerjual) {
        return "TERJUAL";
    } else {
        return "TERSEDIA";
    }
}

public double hitungDiskon() {
    double diskonDasar = super.hitungDiskon();
    int tahunSekarang = 2026;
    int usiaLukisan = tahunSekarang - getTahun();
    
    if (usiaLukisan > 100) {
        return diskonDasar + (getHarga() * 0.10);
    } else if (usiaLukisan > 50) {
        return diskonDasar + (getHarga() * 0.05);
    } else {
        return diskonDasar;
    }
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk meminta input dan menampilkan data.

```bash
for (int i = 0; i < koleksiLukisan.length; i++) {
    ...
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` serta `System.out.printf` untuk menampilkan output.

```bash
Scanner scanner = new Scanner(System.in);
System.out.print("Masukkan Judul Lukisan: ");
String judul = scanner.nextLine();

System.out.println("\nData Lukisan:");
System.out.println(lukisan.displayInfo());
System.out.printf("Diskon: Rp%,.2f\n", diskon);
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `LukisanDetail[] koleksiLukisan = new LukisanDetail[jumlahLukisan];` adalah contoh penggunaan array.

```bash
LukisanDetail[] koleksiLukisan = new LukisanDetail[jumlahLukisan];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error.

```bash
try {
    // code that might throw an exception
    tahun = scanner.nextInt();
    if (tahun < 1000 || tahun > 2026) {
        throw new IllegalArgumentException("Tahun pembuatan tidak valid!");
    }
} catch (InputMismatchException e) {
    System.out.println("ERROR: Input harus berupa angka!");
    scanner.nextLine();
    throw new InputMismatchException("Input tahun harus berupa angka!");
} catch (IllegalArgumentException e) {
    System.out.println("ERROR: " + e.getMessage());
} catch (Exception e) {
    System.out.println("ERROR tidak terduga: " + e.getMessage());
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Muhammad Aldi Saputra
NPM: 2410010507
