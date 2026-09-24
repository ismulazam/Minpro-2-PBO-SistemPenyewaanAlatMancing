package Model;

/**
 *
 * @author mismu
 */

public class AlatMancing {
    private String idAlat;
    private String namaAlat;
    private int stok;

    public AlatMancing(String idAlat, String namaAlat, int stok) {
        this.idAlat = idAlat;
        setNamaAlat(namaAlat);
        setStok(stok);
    }

    public String getIdAlat() { return idAlat; }
    public void setIdAlat(String idAlat) { this.idAlat = idAlat; }

    public String getNamaAlat() { return namaAlat; }
    public void setNamaAlat(String namaAlat) {
        if (namaAlat != null && !namaAlat.trim().isEmpty()) {
            this.namaAlat = namaAlat;
        } else {
            this.namaAlat = "Tanpa Nama";
        }
    }

    public int getStok() { return stok; }
    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println(">> ERROR: Stok tidak boleh negatif! Set ke 0.");
            this.stok = 0;
        }
    }

    // Akan di-Override oleh Joran dan Reel (Polymorphism)
    public void tampilkanInfo() {
        System.out.printf("%-6s | %-20s | %-10s | Stok: %-5d\n", idAlat, namaAlat, "Umum", stok);
    }

    // Method Overloading (Polymorphism)
    public void tambahStok(int tambahan) {
        this.stok += tambahan;
    }
    public void tambahStok(int tambahan, String catatan) {
        this.stok += tambahan;
        System.out.println(">> Catatan Update Stok: " + catatan);
    }
}