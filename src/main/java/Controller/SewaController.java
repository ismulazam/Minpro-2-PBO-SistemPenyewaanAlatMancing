package Controller;

/**
 *
 * @author mismu
 */
import Model.AlatMancing;
import Model.Joran;
import Model.Reel;
import Model.Penyewa;
import Model.Transaksi;
import View.SewaView;
import java.util.ArrayList;

public class SewaController {
    private ArrayList<AlatMancing> daftarAlat;
    private ArrayList<Transaksi> daftarTransaksi; // List kedua untuk fitur transaksi
    private SewaView view;

    public SewaController(SewaView view) {
        this.view = view;
        this.daftarAlat = new ArrayList<>();
        this.daftarTransaksi = new ArrayList<>();
        inisialisasiDummyData();
    }

    private void inisialisasiDummyData() {
        daftarAlat.add(new Joran("J-001", "Maguro Extreme", 15, "Medium Heavy"));
        daftarAlat.add(new Reel("R-001", "Shimano Stella", 5, 12));
    }

    public void mulai() {
        boolean berjalan = true;
        while (berjalan) {
            int pilihan = view.tampilkanMenuUtama();

            switch (pilihan) {
                case 1:
                    view.tampilkanDaftarAlat(daftarAlat);
                    break;
                case 2:
                    tambahData();
                    break;
                case 3:
                    updateStok();
                    break;
                case 4:
                    hapusAlat();
                    break;
                case 5:
                    catatTransaksi();
                    break;
                case 6:
                    view.tampilkanDaftarTransaksi(daftarTransaksi);
                    break;
                case 7:
                    berjalan = false;
                    view.tampilkanPesan("Terima kasih telah menggunakan sistem ini!");
                    break;
                default:
                    view.tampilkanPesan("ERROR: Pilihan tidak valid!");
            }
        }
    }

    private void tambahData() {
        view.tampilkanPesan("--- TAMBAH ALAT BARU ---");
        int jenis = view.inputInt("Pilih Jenis (1. Joran / 2. Reel): ");
        String id = view.inputString("Masukkan ID Alat  : ");
        String nama = view.inputString("Masukkan Nama Alat: ");
        int stok = view.inputInt("Masukkan Stok     : ");

        if (jenis == 1) {
            String kekuatan = view.inputString("Masukkan Kekuatan : ");
            daftarAlat.add(new Joran(id, nama, stok, kekuatan));
            view.tampilkanPesan("SUCCESS: Data Joran berhasil ditambahkan!");
        } else if (jenis == 2) {
            int bearing = view.inputInt("Jumlah Bearing    : ");
            daftarAlat.add(new Reel(id, nama, stok, bearing));
            view.tampilkanPesan("SUCCESS: Data Reel berhasil ditambahkan!");
        } else {
            view.tampilkanPesan("ERROR: Pilihan jenis tidak dikenali.");
        }
    }

    private void updateStok() {
        view.tampilkanPesan("--- UPDATE STOK ---");
        String id = view.inputString("Masukkan ID Alat yang akan diupdate: ");
        AlatMancing alatDitemukan = cariAlat(id);

        if (alatDitemukan != null) {
            int tambah = view.inputInt("Masukkan jumlah tambahan stok: ");
            String catatan = view.inputString("Ketik catatan penambahan: ");
            alatDitemukan.tambahStok(tambah, catatan); // Overloading method
            view.tampilkanPesan("SUCCESS: Stok berhasil diupdate!");
        } else {
            view.tampilkanPesan("ERROR: ID Alat tidak ditemukan!");
        }
    }

    private void hapusAlat() {
        view.tampilkanPesan("--- HAPUS ALAT ---");
        String id = view.inputString("Masukkan ID Alat yang akan dihapus: ");
        AlatMancing alatDitemukan = cariAlat(id);

        if (alatDitemukan != null) {
            daftarAlat.remove(alatDitemukan);
            view.tampilkanPesan("SUCCESS: Alat berhasil dihapus!");
        } else {
            view.tampilkanPesan("ERROR: ID Alat tidak ditemukan!");
        }
    }

    private void catatTransaksi() {
        view.tampilkanPesan("--- CATAT TRANSAKSI ---");
        String idTrans = view.inputString("Masukkan ID Transaksi : ");
        String namaPenyewa = view.inputString("Masukkan Nama Penyewa : ");
        String namaAlat = view.inputString("Masukkan Nama Alat    : ");
        int lama = view.inputInt("Masukkan Lama Sewa    : ");
        
        // Memanfaatkan class Penyewa
        Penyewa penyewa = new Penyewa("P-" + idTrans, namaPenyewa, "08xxxx");
        
        // Memasukkan ke list Transaksi
        Transaksi transaksiBaru = new Transaksi(idTrans, penyewa.getNamaPenyewa(), namaAlat, lama);
        daftarTransaksi.add(transaksiBaru);
        
        view.tampilkanPesan("SUCCESS: Transaksi berhasil dicatat!");
    }

    // Helper khusus internal Controller untuk mencari alat
    private AlatMancing cariAlat(String id) {
        for (AlatMancing alat : daftarAlat) {
            if (alat.getIdAlat().equalsIgnoreCase(id)) {
                return alat;
            }
        }
        return null;
    }
}