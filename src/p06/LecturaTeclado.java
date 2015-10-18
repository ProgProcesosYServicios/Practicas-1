package p06;

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

public class LecturaTeclado {

	/**
	 * Programa principal. Lanza la hebra, lee por teclado una cadena,
	 * y entra en un bucle infinito.
	 * 
	 * @param args Argumentos enviados desde la línea de
	 * comandos. No se utilizan.
	 */
	public static void main(String[] args) {
		
		MiHebra mh = new MiHebra();
		mh.start();

		System.out.println("Escribe algo (¡no la línea vacía!): ");
		// Leemos de teclado (y despreciamos) el siguiente token. 
		java.util.Scanner scanner;
		scanner = new java.util.Scanner(System.in);
		scanner.next();

		// Bucle infinito.
		while(true)
			;

	} // main

} // class LecturaTeclado
