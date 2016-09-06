package p11.b;


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

		// Bucle infinito.
		while(true)
			;
		
	} // run

} // MiHebra

//-------------------------------------------------------------------

/**
 * Clase principal de la aplicación. Lanza la hebra y termina.
 * 
 * @author Pedro Pablo Gómez Martín
 */
public class FinMain {

	/**
	 * Programa principal.
	 * 
	 * @param args Argumentos enviados desde la línea de
	 * comandos. No se utilizan.
	 * 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Lanzamos la hebra ... ");
		MiHebra mh = new MiHebra();
		mh.setDaemon(true);
		mh.start();
		Thread.sleep(10000);
		System.out.println("... y acabamos");

	} // main

} // class FinMain
