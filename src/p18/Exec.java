package p18;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Exec {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.err.println("No has especificado parámetros");
			return;
		} else if (args.length > 1) {
			System.err.println("Demasiados parámetros. "
					+ "Pon el comando entre comillas.");
			return;
		}
		String comando = args[0];

		try {

			Process proc = Runtime.getRuntime().exec(comando);
			PassThrough salidaEstandar, salidaError;
			salidaEstandar = new PassThrough(proc.getInputStream(), System.out);
			salidaError = new PassThrough(proc.getErrorStream(), System.err);

			Thread t1, t2;
			t1 = new Thread(salidaEstandar);
			t2 = new Thread(salidaError);
			t1.start();
			t2.start();
			int result = proc.waitFor();

			InputStream is = proc.getInputStream();

			System.out.println("Resultado de " + comando + ": " + result);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

}

class PassThrough implements Runnable {

	private static final int BUFFER = 1024 * 16;
	InputStream is;
	OutputStream os;

	public PassThrough(InputStream is, OutputStream os) {
		this.is = is;
		this.os = os;

	}

	public void run() {
		byte[] buffer = new byte[BUFFER];
		int leidos;
		try {
			while ((leidos = is.read(buffer)) != -1) {
				os.write(buffer, 0, leidos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
