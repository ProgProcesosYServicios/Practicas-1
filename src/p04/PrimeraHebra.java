package p04;

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
 * Clase principal de la aplicación. Lanza la hebra y luego
 * se queda dando vueltas en un bucle infinito.
 * 
 * @author Pedro Pablo Gómez Martín
 */
public class PrimeraHebra {

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

} // class PrimeraHebra
