package View;

/**
 *
 * @author mismu
 */
import Model.AlatMancing;
import Model.Transaksi;
import java.util.ArrayList;
import java.util.Scanner;

public class SewaView {
    private Scanner scanner = new Scanner(System.in);

    public int tampilkanMenuUtama() {
        System.out.println("\n==============================================");
        System.out.println(" SISTEM MANAJEMEN PENYEWAAN ALAT MANCING (V2)");
        System.out.println("==============================================");
        System.out.println("1. Tampilkan Data Alat Mancing");
        System.out.println("2. Tambah Alat Mancing Baru");
        System.out.println("3. Update Stok Alat Mancing");
        System.out.println("4. Hapus Alat Mancing");
        System.out.println("5. Catat Transaksi Sewa Baru");
        System.out.println("6. Tampilkan Riwayat Transaksi");
        System.out.println("7. Keluar");
        System.out.print("Pilih menu (1-7): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return pilihan;
    }

    public void tampilkanDaftarAlat(ArrayList<AlatMancing> daftar) {
        System.out.println("\n--- DAFTAR ALAT MANCING ---");
        if (daftar.isEmpty()) {
            System.out.println("Data alat mancing kosong.");
        } else {
            for (AlatMancing alat : daftar) {
                alat.tampilkanInfo(); // Memanggil method Override Joran/Reel
            }
        }
    }

    public void tampilkanDaftarTransaksi(ArrayList<Transaksi> daftar) {
        System.out.println("\n--- RIWAYAT TRANSAKSI ---");
        if (daftar.isEmpty()) {
            System.out.println("Belum ada data transaksi.");
        } else {
            System.out.printf("%-10s | %-20s | %-20s | %-10s\n", "ID Trans", "Nama Penyewa", "Alat Disewa", "Lama (Hari)");
            System.out.println("-------------------------------------------------------------------------");
            for (Transaksi t : daftar) {
                t.tampilkanTransaksi();
            }
        }
    }

    // Helper method untuk meminta input teks
    public String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Helper method untuk meminta input angka
    public int inputInt(String prompt) {
        System.out.print(prompt);
        int nilai = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return nilai;
    }

    // Helper untuk menampilkan notifikasi sukses/error
    public void tampilkanPesan(String pesan) {
        System.out.println(">> " + pesan);
    }
}