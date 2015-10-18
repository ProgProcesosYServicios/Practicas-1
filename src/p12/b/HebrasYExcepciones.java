package p12.b;


/**
 * Clase no pública que hereda de Thread para ser ejecutada
 * en una hebra independiente. Lanza nada más empezar una RuntimeException.
 * 
 * @author Pedro Pablo Gómez Martín
 */
class MiHebra extends Thread {

	/**
	 * Código principal de la hebra. Se lanzará en un hilo de
	 * ejecución diferente cuando se llame al método start() del
	 * objeto. Lanza una excepción.
	 */
	public void run() {

		throw new NullPointerException();
		
	} // run

} // MiHebra

//-------------------------------------------------------------------

/**
 * Clase principal de la aplicación. Lanza la hebra y espera a
 * que termine.
 * 
 * @author Pedro Pablo Gómez Martín
 */
public class HebrasYExcepciones
             implements Thread.UncaughtExceptionHandler {
	
	/**
	 * Programa principal.
	 * 
	 * @param args Argumentos enviados desde la línea de
	 * comandos. No se utilizan.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		MiHebra mh = new MiHebra();
		mh.setUncaughtExceptionHandler(new HebrasYExcepciones());
		mh.start();
		
		mh.join();
		
		System.out.println("La hebra ha terminado.");

	} // main

	//---------------------------------------------------------------
	
	/**
	 * Método del interfaz Thread.UncaughtExceptionHandler. Es invocado
	 * cuando una hebra en la que nos hemos registrado como manejadores
	 * acaba precipitadamente por culpa de una excepción no controlada.
	 * 
	 * @param t Hebra que ha terminado precipitadamente.
	 * @param e Excepción que ha ocasionado la finalización.
	 */
	@Override
	public void uncaughtException(Thread t, Throwable e) {

		System.out.println("La hebra " + t + " acabó por " + e);
		System.out.println("(ejecutándome desde " + Thread.currentThread() + ")");

	} // uncaughtException

} // HebrasYExcepciones 
