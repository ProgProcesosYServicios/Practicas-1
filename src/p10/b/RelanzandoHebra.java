package p10.b;


/**
 * Clase no pública que hereda de Thread para ser ejecutada
 * en una hebra independiente. Espera 60 segundos y termina.
 * 
 * @author Pedro Pablo Gómez Martín
 */
class MiHebra extends Thread {

	/**
	 * Código principal de la hebra. Se lanzará en un hilo de
	 * ejecución diferente cuando se llame al método start() del
	 * objeto. Espera un segundo y termina.
	 */
	public void run() {

		System.out.println("[hebra]:\tDormimos un rato.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// Ignoramos la excepción.
		}
		System.out.println("[hebra]:\tTerminamos.");
		
	} // run

} // MiHebra

//-------------------------------------------------------------------

/**
 * Clase principal de la aplicación. Lanza la hebra, y espera a que
 * termine usando join(). Luego la relanza de nuevo.
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

		MiHebra mh = new MiHebra();
		System.out.println("[main]: Lanzando la hebra...");
		mh.start();
		System.out.println("[main]: Esperamos a que termine.");
		mh.join();
		System.out.println("[main]: Relanzamos la hebra.");
		mh.run();

		// Bucle infinito.
		while(true)
			;

	} // main
	
} // RelanzandoHebra
