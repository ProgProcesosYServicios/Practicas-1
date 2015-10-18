package p07;

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
 * Clase principal de la aplicación. Lanza tantas hebras como
 * se indique como argumento a la aplicación. Un 0 (o sin parámetros)
 * indica "infinitas", por lo que se lanzarán hebras sin cesar.
 * 
 * @author Pedro Pablo Gómez Martín
 */
public class SaturacionDeHebras {

	/**
	 * Programa principal. Lanza las hebras y ejecuta un bucle
	 * infinito.
	 * 
	 * @param args Argumentos enviados desde la línea de
	 * comandos. Se espera que el primero, si existe, sea
	 * un número con la cantidad de hebras que hay que lanzar.
	 */
	public static void main(String[] args) {

		int numHebras = 0;
		if (args.length > 0) {
			try {
				numHebras = Integer.parseInt(args[0]);
				System.out.println("Crearemos " + numHebras + " hebras.");
			}
			catch (NumberFormatException nfe) {
				// El número no lo entendemos...
				System.out.println("Parámetro inválido. Se asume 0.");
			}
		}
		
		System.out.println("Escribe algo para empezar (¡no la línea vacía!): ");
		// Leemos de teclado (y despreciamos) el siguiente token. 
		java.util.Scanner scanner;
		scanner = new java.util.Scanner(System.in);
		scanner.next();

		int i = 0;
		while ((numHebras == 0) || (i < numHebras)) {
			System.out.println("Creando hebra número " + i);
			MiHebra mh;
			mh = new MiHebra();
			mh.start();
			++i;
		} // while

		// Bucle infinito para cuando no se lancen
		// infinitas hebras.
		System.out.println("Todas creadas!. Esperamos...");
		while(true)
			;

	} // main

} // SaturacionDeHebras
