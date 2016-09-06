package p17;

/**
 * Clase no pública que implementa el interfaz Runnable. Podra
 * ser ejecutado por un objeto Thread que reciba una instancia
 * de esta clase en su constructor.
 * 
 * @author Pedro Pablo Gómez Martín
 */
class MiRunnable implements Runnable {
 
    /**
     * Código llamado por la hebra Ejecuta un bucle infinito que
     * no hace nada.
     */
    public void run() {
 
        // Bucle infinito.
        while(true)
            ;
         
    } // run
 
} // MiRunnable
 
//-------------------------------------------------------------------
 
/**
 * Clase principal de la aplicación. Lanza la hebra y luego
 * se queda dando vueltas en un bucle infinito.
 * 
 * @author Pedro Pablo Gómez Martín
 */
public class PrimerRunnable {
 
    /**
     * Programa principal. Lanza la hebra y ejecuta un bucle
     * infinito.
     * 
     * @param args Argumentos enviados desde la línea de
     * comandos. No se utilizan.
     */
    public static void main(String[] args) {
         
        MiRunnable mr = new MiRunnable();
        Thread t = new Thread(mr);
        t.start();
         
        // Bucle infinito.
        while(true)
            ;
 
    } // main
 
} // class PrimerRunnable