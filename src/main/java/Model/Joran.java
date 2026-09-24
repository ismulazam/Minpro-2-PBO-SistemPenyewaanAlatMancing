/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author mismu
 */
public class Joran extends AlatMancing {
    private String kekuatan; 

    public Joran(String idAlat, String namaAlat, int stok, String kekuatan) {
        super(idAlat, namaAlat, stok); 
        this.kekuatan = kekuatan;
    }

    public String getKekuatan() { return kekuatan; }

    // Polymorphism: Method Overriding
    @Override
    public void tampilkanInfo() {
        System.out.printf("%-6s | %-20s | %-10s | Stok: %-5d | Kekuatan: %s\n", 
                getIdAlat(), getNamaAlat(), "Joran", getStok(), kekuatan);
    }
}
