/**
 * Salarios y complementos de empleados.
 */
package nominas;
import java.util.Scanner;

/**
 * <H2><u>Clase que determina la prima correspondiente a empleados seg�n
 * categor�a y meses de antig�edad.</u></H2>
 * 
 * @author Covadonga Queipo S�nchez
 * @version v.1 24/04/2022
 * {@docRoot}
 */
public class PrimaMainMetodos {

	/**
	 * Variable de la instancia Scanner
	 */
	static Scanner teclado = new Scanner(System.in);
	
	/**
	 * M�todo principal que halla la prima de cada empleado. 
	 * 	<ol>
	 * 		<li>Asigna los datos de empleados.</li>
	 * 		<li>Procesa los datos asignados.</li>
	 * 		<li>Visualiza el resultado, valor de la prima que corresponde a cada empleado.</li>
	 * 	</ol>
	 * <br>
	 * Proceso que se repite mientras se desea calcular m�s primas a otros empleados.
	 *
	 * @param args No recibe argumento alguno.
	 */
	public static void main(String[] args) {

		// ATRIBUTOS

		/**
		 * Variable de tipo entero que identificar� el n�mero del empleado.
		 */
		int numEmple;
		/**
		 * Variable de tipo cadena que identificar� el nombre del empleado.
		 */
		String nomEmple;
		/**
		 * Variable de tipo entero que identificar� los meses de antig�edad.
		 */
		int meses;
		/**
		 * Variable de tipo caracter que identificar� la categor�a del empleado.
		 */
		char esDirectivo;
		/**
		 * Variable de tipo caracter que identificar� una respuesta.
		 */
		char respuesta;

		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple = leerNumEmple();
			nomEmple = leerNomEmple();
			meses = leerMeses();
			esDirectivo = leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima " + hallarPrima(esDirectivo, meses));

			System.out.println("\n�CALCULAR MAS PRIMAS? (S/N): ");
			respuesta = teclado.nextLine().toUpperCase().charAt(0);
		} while (respuesta == 'S');
	}

	/**
	 * M�todo que halla la prima correspondiente a cada empleado. 
	 * 	<ul>
	 * 		<li> 
	 * 			Si el empleado es Directivo (+) y,
	 * 			<ul>
	 * 				<li>si tiene una antig�edad >= a 12 meses devuelve <strong>P1</strong></li>
	 * 				<li>si tiene una antig�edad menor de 12 meses retorna la prima <strong>P3</strong></li>
	 * 			</ul><br>
	 * 		</li>
	 * 		<li>Si el empleado no es Directivo (-) y,
	 * 			<ul>
 	 *				<li>si tiene una antig�edad >= a 12 meses devuelve la prima <strong>P2</strong>.</li>
	 * 			</ul>
	 * 		</li>
	 * 	</ul>
	 * 
	 * @param esDirectivo recibe el valor de retorno del m�todo leerEsDirectivo(), + o - .
	 * @param meses       recibe el valor de retorno del m�todo leerMeses()), meses de antig�edad.
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
	 * M�todo que asigna por teclado el n�mero del empleado. No puede ser menor de
	 * 100 o mayor de 999.
	 * 
	 * @return devuelve el n�mero del empleado asignado.
	 */
	public static int leerNumEmple() {
		/**
		 * Variable de tipo entero que dentificar� el n�mero del empleado.
		 */
		int numEmple;
		do {
			System.out.println("N�MERO [100-999]: ");
			numEmple = teclado.nextInt();
		} while (numEmple < 100 || numEmple > 999);
		teclado.nextLine();
		return numEmple;
	}

	/**
	 * M�todo que asigna por teclado el nombre del empleado. 
	 * No puede tener m�s de 10 caracteres.
	 * 
	 * @return devuelve el nombre del empleado asignado.
	 */
	public static String leerNomEmple() {
		/**
		 * Variable de tipo cadena al que se le asignar� un nombre de empleado.
		 */
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		} while (nomEmple.length() > 10);
		return nomEmple;
	}

	/**
	 * M�todo que asigna por teclado los meses correspondientes a la antig�edad del
	 * empleado.
	 * 
	 * @return devuelve los meses de antig�edad asignados.
	 */
	public static int leerMeses() {
		/**
		 * Variable de tipo entero al que se le asignar� los meses de antig�edad del
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
	 * M�todo que asigna por teclado el valor de la categor�a del empleado.
	 * 	<br><ul>
     *		<li> + si es directivo</li>
	 * 		<li> - si no es directivo.</li>
	 * 	</ul>
	 * 
	 * @return devuelve el valor de la categor�a asignada.
	 */
	public static char leerEsDirectivo() {
		/**
		 * Variable de tipo caracter al que se le asignar� por teclado el valor de la categor�a del
		 * empleado.
		 */
		char esDirectivo;
		do {
			System.out.println("�ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		} while (esDirectivo != '+' && esDirectivo != '-');
		return esDirectivo;
	}
}

