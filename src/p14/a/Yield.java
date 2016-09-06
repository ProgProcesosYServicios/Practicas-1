package p14.a;

/**
 * Clase no pública que hereda de Thread para ser ejecutada
 * en una hebra independiente. Ejecuta un bucle infinito en
 * el que cuenta contínuamente de manera ascendente, escribiendo
 * un número de cada 100.
 * 
 * @author Pedro Pablo Gómez Martín
 */
class MiHebra extends Thread {
 
    public MiHebra(boolean tabular) {
        _tabular = tabular;
    }
 
    /**
     * Código principal de la hebra. Se lanzará en un hilo de
     * ejecución diferente cuando se llame al método start() del
     * objeto. Ejecuta un bucle infinito que cuenta de manera
     * ascendente, escribiendo un número de cada 100.
     */
    public void run() {
         
        long i = 0;
        while(true) {
            ++i;
            if ((i % 100) == 0) {
                if (_tabular)
                    System.out.print("\t");
                System.out.println(i);
            }
        } // while
         
    } // run
 
    boolean _tabular;
 
} // MiHebra
 
//-------------------------------------------------------------------
 
/**
* Clase principal de la aplicación. Lanza dos hebras semejantes y
* termina.
* 
* @author Pedro Pablo Gómez Martín
*/
public class Yield {
     
    /**
     * Programa principal.
     * 
     * @param args Argumentos enviados desde la línea de
     * comandos. No se utilizan.
     */
    public static void main(String[] args) {
         
        MiHebra mh = new MiHebra(false);
        mh.start();
        mh = new MiHebra(true);
        mh.start();
 
    } // main
 
} // class Yield