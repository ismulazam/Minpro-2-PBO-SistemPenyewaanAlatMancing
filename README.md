# Minpro-2-PBO-SistemPenyewaanAlatMancing

Oleh: Muhammad Ismul Azam Atmoko

## 1. Deskripsi Singkat Program
Program ini merupakan iterasi kedua dari Sistem Manajemen Penyewaan Alat Mancing yang dibangun menggunakan Java berbasis CLI (Command Line Interface). Pada versi ini, sistem telah dirombak menggunakan arsitektur MVC (Model-View-Controller) untuk memisahkan antara logika data, antarmuka pengguna, dan kontrol program. Program ini mengelola inventaris alat mancing dan riwayat transaksi sewa dengan menerapkan pilar utama Object-Oriented Programming (OOP) tingkat lanjut.

## 2. Penjelasan Alur Program
Alur eksekusi program diatur secara terpusat melalui arsitektur MVC:
1. **Inisialisasi (Main)**: Program dimulai dari `Main.java` yang bertugas menciptakan objek `SewaView` (layar interaktif) dan `SewaController` (pengendali logika), lalu memicu metode `mulai()`.
2. **Setup Data (Controller)**: Saat `SewaController` dibentuk, sistem otomatis memuat *dummy data* ke dalam `ArrayList` agar program langsung memiliki data awal yang bisa ditampilkan.
3. **Looping & Input (View)**: `SewaView` menampilkan menu utama (1-7) dan menerima input dari pengguna menggunakan `Scanner`. 
4. **Pemrosesan (Controller)**: Berdasarkan input yang dikembalikan oleh View, Controller menggunakan struktur `switch-case` untuk mengeksekusi fungsi CRUD. 
5. **Tampil Data (View)**: Setelah Controller memproses data, Controller mengirimkan kembali data tersebut ke View untuk dicetak ke layar. Program berulang hingga memilih Keluar.

## 3. Penjelasan Penerapan Encapsulation dan Inheritance

### Encapsulation (Pengkapsulan) & Validasi
Seluruh atribut di dalam package `Model` menggunakan access modifier `private`. Akses dibatasi melalui method `Getter` dan `Setter`. Di dalam method *Setter*, disisipkan validasi logika (misalnya stok tidak boleh diinputkan angka negatif, dan akan otomatis direset ke 0 jika terjadi).

**Bukti Output Validasi Encapsulation (Stok Negatif Ditolak):**
<img width="352" height="328" alt="image" src="https://github.com/user-attachments/assets/901dbac7-02fb-4e80-ad57-f6c1fc759ca1" />


### Inheritance (Pewarisan)
Program memiliki hierarki class, di mana class `AlatMancing` bertindak sebagai **Superclass** (induk). Class ini diturunkan kepada 2 **Subclass** (anak), yaitu:
1. `Joran` (Mewarisi atribut induk + menambahkan atribut spesifik `kekuatan`).
2. `Reel` (Mewarisi atribut induk + menambahkan atribut spesifik `jumlahBearing`).

## 4. Penjelasan Letak Penerapan Nilai Tambah
Sistem ini mengimplementasikan dua nilai tambah (Opsional) secara penuh:

### A. Struktur MVC (Model-View-Controller)
Program dipecah menjadi 4 *package* khusus (`Model`, `View`, `Controller`, `Main`).
**Bukti Struktur Package MVC:**
<img width="253" height="251" alt="image" src="https://github.com/user-attachments/assets/2ae26b5b-5288-4541-a26a-56dd97d74421" />


### B. Polymorphism (Banyak Bentuk)

**1. Method Overriding**
Terdapat pada subclass `Joran` dan `Reel` yang menimpa method `tampilkanInfo()` milik superclass `AlatMancing`. Hasilnya, Joran bisa mencetak "Kekuatan" dan Reel bisa mencetak "Bearing" pada satu perulangan cetak yang sama.
**Bukti Output Overriding (Perbedaan atribut cetak Joran & Reel):**
<img width="591" height="269" alt="image" src="https://github.com/user-attachments/assets/84d8e522-0ccf-4dab-899e-4998b305aa6a" />


**2. Method Overloading**
Terdapat pada superclass `AlatMancing`, yaitu penyediaan dua method bernama sama dengan parameter berbeda: `tambahStok(int tambahan)` dan `tambahStok(int tambahan, String catatan)`.
**Bukti Output Overloading (Pencetakan Catatan Tambahan di Menu Update):**
<img width="342" height="294" alt="image" src="https://github.com/user-attachments/assets/75171f10-91be-47db-a822-53f6a1e94adf" />
