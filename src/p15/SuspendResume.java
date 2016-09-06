package p15;

 
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
 
    public void setOtherThread(Thread thread) {
        _thread = thread;
    }
 
    /**
     * Código principal de la hebra. Se lanzará en un hilo de
     * ejecución diferente cuando se llame al método start() del
     * objeto. Ejecuta un bucle infinito que cuenta de manera
     * ascendente, escribiendo un número de cada 100.
     */
    public void run() {
        if (_tabular)
            suspend();
        long i = 0;
        while(true) {
            ++i;
            if ((i % 100) == 0) {
                if (_tabular)
                    System.out.print("\t");
                System.out.println(i);
                _thread.resume();
                suspend();
            }
        } // while
         
    } // run
 
    boolean _tabular;
     
    Thread _thread;
 
} // MiHebra
 
//-------------------------------------------------------------------
 
/**
* Clase principal de la aplicación. Lanza dos hebras semejantes y
* termina.
* 
* @author Pedro Pablo Gómez Martín
*/
public class SuspendResume {
     
    /**
     * Programa principal.
     * 
     * @param args Argumentos enviados desde la línea de
     * comandos. No se utilizan.
     */
    public static void main(String[] args) {
         
        MiHebra mh1 = new MiHebra(false);
        MiHebra mh2 = new MiHebra(true);
        mh1.setOtherThread(mh2);
        mh2.setOtherThread(mh1);
        mh1.start();
        mh2.start();
 
    } // main
 
} // class Yield