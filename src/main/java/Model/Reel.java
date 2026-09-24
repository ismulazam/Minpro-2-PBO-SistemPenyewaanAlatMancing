package Model;

/**
 *
 * @author mismu
 */
public class Reel extends AlatMancing {
    private int jumlahBearing; 

    public Reel(String idAlat, String namaAlat, int stok, int jumlahBearing) {
        super(idAlat, namaAlat, stok);
        this.jumlahBearing = jumlahBearing > 0 ? jumlahBearing : 1; // Validasi sebaris
    }

    public int getJumlahBearing() { return jumlahBearing; }

    // Polymorphism: Method Overriding
    @Override
    public void tampilkanInfo() {
        System.out.printf("%-6s | %-20s | %-10s | Stok: %-5d | Bearing: %d\n", 
                getIdAlat(), getNamaAlat(), "Reel", getStok(), jumlahBearing);
    }
}
