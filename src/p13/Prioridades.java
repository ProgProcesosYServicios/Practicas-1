
package p13;
 
/**
 * Clase no pública que hereda de Thread para ser ejecutada
 * en una hebra independiente. Ejecuta un bucle infinito.
 * 
 * @author Pedro Pablo Gómez Martín
 */
class MiHebra extends Thread {
     
    public MiHebra(String name) {
        super(name);
    }
 
    /**
     * Código principal de la hebra. Se lanzará en un hilo de
     * ejecución diferente cuando se llame al método start() del
     * objeto. Ejecuta un bucle infinito.
     */
    public void run() {
        System.out.println("Iniciada hebra " + this);
        while(true)
            ;
         
    } // run
 
} // MiHebra
 
//-------------------------------------------------------------------
 
/**
 * Clase principal de la aplicación. Lanza hebras con diferente
 * prioridad.
 * 
 * @author Pedro Pablo Gómez Martín
 */
public class Prioridades {
     
    /**
     * Programa principal.
     * 
     * @param args Argumentos enviados desde la línea de
     * comandos. No se utilizan.
     */
    public static void main(String[] args) {
         
        MiHebra mh = new MiHebra("Lenta");
        mh.setPriority(Thread.MIN_PRIORITY);
        mh.start();
        mh = new MiHebra("Rapida");
        mh.setPriority(Thread.MAX_PRIORITY);
        mh.start();
 
    } // main
 
} // class Prioridades 