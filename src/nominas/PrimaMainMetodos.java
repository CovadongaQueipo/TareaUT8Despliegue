/**
 * Salarios y complementos de empleados.
 */
package nominas;
import java.util.Scanner;

/**
 * <H2><u>Clase que determina la prima correspondiente a empleados según
 * categoría y meses de antigüedad.</u></H2>
 * 
 * @author Covadonga Queipo Sánchez
 * @version v.1 24/04/2022
 * {@docRoot}
 */
public class PrimaMainMetodos {

	/**
	 * Variable de la instancia Scanner
	 */
	static Scanner teclado = new Scanner(System.in);
	
	/**
	 * Método principal que halla la prima de cada empleado. 
	 * 	<ol>
	 * 		<li>Asigna los datos de empleados.</li>
	 * 		<li>Procesa los datos asignados.</li>
	 * 		<li>Visualiza el resultado, valor de la prima que corresponde a cada empleado.</li>
	 * 	</ol>
	 * <br>
	 * Proceso que se repite mientras se desea calcular más primas a otros empleados.
	 *
	 * @param args No recibe argumento alguno.
	 */
	public static void main(String[] args) {

		// ATRIBUTOS

		/**
		 * Variable de tipo entero que identificará el número del empleado.
		 */
		int numEmple;
		/**
		 * Variable de tipo cadena que identificará el nombre del empleado.
		 */
		String nomEmple;
		/**
		 * Variable de tipo entero que identificará los meses de antigüedad.
		 */
		int meses;
		/**
		 * Variable de tipo caracter que identificará la categoría del empleado.
		 */
		char esDirectivo;
		/**
		 * Variable de tipo caracter que identificará una respuesta.
		 */
		char respuesta;

		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple = leerNumEmple();
			nomEmple = leerNomEmple();
			meses = leerMeses();
			esDirectivo = leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima " + hallarPrima(esDirectivo, meses));

			System.out.println("\n¿CALCULAR MAS PRIMAS? (S/N): ");
			respuesta = teclado.nextLine().toUpperCase().charAt(0);
		} while (respuesta == 'S');
	}

	/**
	 * Método que halla la prima correspondiente a cada empleado. 
	 * 	<ul>
	 * 		<li> 
	 * 			Si el empleado es Directivo (+) y,
	 * 			<ul>
	 * 				<li>si tiene una antigüedad >= a 12 meses devuelve <strong>P1</strong></li>
	 * 				<li>si tiene una antigüedad menor de 12 meses retorna la prima <strong>P3</strong></li>
	 * 			</ul><br>
	 * 		</li>
	 * 		<li>Si el empleado no es Directivo (-) y,
	 * 			<ul>
 	 *				<li>si tiene una antigüedad >= a 12 meses devuelve la prima <strong>P2</strong>.</li>
	 * 			</ul>
	 * 		</li>
	 * 	</ul>
	 * 
	 * @param esDirectivo recibe el valor de retorno del método leerEsDirectivo(), + o - .
	 * @param meses       recibe el valor de retorno del método leerMeses()), meses de antigüedad.
	 * @return 			  Devuelve el valor de la prima correspondiente.
	 */
	public static String hallarPrima(char esDirectivo, int meses) {
		if (esDirectivo == '+') // ES DIRECTIVO
			if (meses >= 12)
				return "P1";
			else
				return "P3";
		else // NO ES DIRECTIVO
		if (meses >= 12)
			return "P2";
		else
			return "P4";
	}

	/**
	 * Método que asigna por teclado el número del empleado. No puede ser menor de
	 * 100 o mayor de 999.
	 * 
	 * @return devuelve el número del empleado asignado.
	 */
	public static int leerNumEmple() {
		/**
		 * Variable de tipo entero que dentificará el número del empleado.
		 */
		int numEmple;
		do {
			System.out.println("NÚMERO [100-999]: ");
			numEmple = teclado.nextInt();
		} while (numEmple < 100 || numEmple > 999);
		teclado.nextLine();
		return numEmple;
	}

	/**
	 * Método que asigna por teclado el nombre del empleado. 
	 * No puede tener más de 10 caracteres.
	 * 
	 * @return devuelve el nombre del empleado asignado.
	 */
	public static String leerNomEmple() {
		/**
		 * Variable de tipo cadena al que se le asignará un nombre de empleado.
		 */
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		} while (nomEmple.length() > 10);
		return nomEmple;
	}

	/**
	 * Método que asigna por teclado los meses correspondientes a la antigüedad del
	 * empleado.
	 * 
	 * @return devuelve los meses de antigüedad asignados.
	 */
	public static int leerMeses() {
		/**
		 * Variable de tipo entero al que se le asignará los meses de antigüedad del
		 * empleado.
		 */
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		} while (meses < 0);
		teclado.nextLine();
		return meses;
	}

	/**
	 * Método que asigna por teclado el valor de la categoría del empleado.
	 * 	<br><ul>
     *		<li> + si es directivo</li>
	 * 		<li> - si no es directivo.</li>
	 * 	</ul>
	 * 
	 * @return devuelve el valor de la categoría asignada.
	 */
	public static char leerEsDirectivo() {
		/**
		 * Variable de tipo caracter al que se le asignará por teclado el valor de la categoría del
		 * empleado.
		 */
		char esDirectivo;
		do {
			System.out.println("¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		} while (esDirectivo != '+' && esDirectivo != '-');
		return esDirectivo;
	}
}

