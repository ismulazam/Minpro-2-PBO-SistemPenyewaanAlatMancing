package Main;

/**
 *
 * @author mismu
 */
import Controller.SewaController;
import View.SewaView;

public class Main {
    public static void main(String[] args) {
        // Menginisiasi View (Tampilan Layar & Scanner)
        SewaView view = new SewaView();
        
        // Menginisiasi Controller (Logika & Data) dengan memasukkan View
        SewaController controller = new SewaController(view);
        
        // Menjalankan loop program utama
        controller.mulai();
    }
}
