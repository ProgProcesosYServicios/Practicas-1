package p08;

/**
 * Clase no pública que hereda de Thread para ser ejecutada
 * en una hebra independiente. Alterna entre un sleep() y
 * un bucle que cuenta (espera activa).
 * 
 * @author Pedro Pablo Gómez Martín
 */
class MiHebra extends Thread {

	/**
	 * Código principal de la hebra. Se lanzará en un hilo de
	 * ejecución diferente cuando se llame al método start() del
	 * objeto. Se alterna entre un sleep y un bucle que "cuenta"
	 * (espera activa).
	 */
	public void run() {

		long i;
		while(true) {
			// Dormimos un rato.
			System.out.println("Dormimos...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// Si salta esta excepción, la ignoramos.
			}
			// Espera activa.
			System.out.println("Espera activa...");
			for (i = 0; i < 0x7FFFFFFF; ++i)
				;
		}
	} // run

} // MiHebra

//-------------------------------------------------------------------

/**
 * Clase principal de la aplicación. Lanza la hebra y luego
 * se queda dando vueltas en un bucle infinito.
 * 
 * @author Pedro Pablo Gómez Martín
 */
public class Sleep {

	/**
	 * Programa principal. Lanza la hebra y ejecuta un bucle
	 * infinito.
	 * 
	 * @param args Argumentos enviados desde la línea de
	 * comandos. No se utilizan.
	 */
	public static void main(String[] args) {
		
		MiHebra mh = new MiHebra();
		mh.start();
		
		// Bucle infinito.
		while(true)
			;

	} // main
	
} // Sleep
