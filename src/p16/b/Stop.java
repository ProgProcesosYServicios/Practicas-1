package p16.b;

/**
 * Clase no pública que hereda de Thread para ser ejecutada
 * en una hebra independiente. Ejecuta un bucle infinito.
 * 
 * @author Pedro Pablo Gómez Martín
 */
class MiHebra extends Thread {
 
    /**
     * Código principal de la hebra. Se lanzará en un hilo de
     * ejecución diferente cuando se llame al método start() del
     * objeto. Ejecuta un bucle infinito que no hace nada.
     */
    public void run() {
        long a = 0;
        // Bucle infinito.
        while(true) {
            try {
                ++a;
            }
            catch(ThreadDeath t) {
                System.out.println("Tururu!");
            }
        }
         
    } // run
 
} // MiHebra
 
//-------------------------------------------------------------------
 
/**
 * Clase principal de la aplicación. Lanza la hebra espera un instante,
 * detiene la hebra (con stop()) y mira su estado.
 * 
 * @author Pedro Pablo Gómez Martín
 */
public class Stop {
 
    /**
     * Programa principal. Lanza la hebra y ejecuta un bucle
     * infinito.
     * 
     * @param args Argumentos enviados desde la línea de
     * comandos. No se utilizan.
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
         
        MiHebra mh = new MiHebra();
        System.out.println("Lanzamos la hebra y esperamos un momento...");
        mh.start();
        Thread.sleep(1000);
        System.out.println("Detenemos la hebra...");
        mh.stop();
        // Esperamos un momento para darla tiempo a terminar.
        Thread.sleep(500);
        if (mh.isAlive())
            System.out.println("La hebra sigue viva! Pulsa Ctrl-C para terminar...");
 
    } // main
 
} // class PrimeraHebra