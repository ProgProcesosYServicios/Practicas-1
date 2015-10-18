package p09;

/**
 * Clase no pública que hereda de Thread para ser ejecutada
 * en una hebra independiente. Espera un segundo y termina.
 * 
 * @author Pedro Pablo Gómez Martín
 */
class MiHebra3 extends Thread {

	/**
	 * Código principal de la hebra. Se lanzará en un hilo de
	 * ejecución diferente cuando se llame al método start() del
	 * objeto. Espera un segundo y termina.
	 */
	public void run() {

		System.out.println("[hebra]:\tDormimos un rato.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// Ignoramos la excepción.
		}
		System.out.println("[hebra]:\tTerminamos.");
		
	} // run

} // MiHebra

//-------------------------------------------------------------------

/**
 * Clase principal de la aplicación. Lanza la hebra, espera 3 segundos
 * con la esperanza de que haya terminado ya, y la relanza de nuevo.
 * 
 * @author Pedro Pablo Gómez Martín
 */
public class RelanzandoHebra {
	
	/**
	 * Programa principal.
	 * 
	 * @param args Argumentos enviados desde la línea de
	 * comandos. No se utilizan.
	 */
	public static void main(String[] args) throws InterruptedException {

		MiHebra3 mh = new MiHebra3();
		System.out.println("[main]: Lanzando la hebra...");
		mh.start();
		System.out.println("[main]: Dormimos un rato.");
		Thread.sleep(3000);
		// Hemos dado tiempo suficiente para que la hebra termine.
		System.out.println("[main]: Relanzamos la hebra.");
		mh.start();

		// Bucle infinito.
		while(true)
			;

	} // main
	
} // RelanzandoHebra
