package aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelos.Cliente;
import modelos.Factura;
import modelos.Producto;
import modelos.Proveedor;

public class Aplicacion {

	private static Scanner teclado;

	public static void main(String[] args) {

		teclado = new Scanner(System.in);

		List<Cliente> clientes = new ArrayList<>();
		List<Proveedor> proveedores = new ArrayList<>();
		List<Producto> productos = new ArrayList<>();
		List<Factura> facturas = new ArrayList<>();
		
		System.out.println("Hola Mundo");

	}

	public static void mostrarMenuPrincipal() {

		System.out.println("=== MENU PRINCIPAL ===");
		System.out.println("1. Gestion Clientes");
		System.out.println("2. Gestion Proveedores");
		System.out.println("3. Gestion Productos");
		System.out.println("4. Gestion Facturacion");
		System.out.println("0. Salir");
	}

	public static void mostrarSubMenu(String tipoMenu) {

		System.out.printf("*** Menu Gestion %s***\n", tipoMenu);
		System.out.println("1. Crear");
		System.out.println("2. Buscar");
		System.out.println("3. Actualizar");
		System.out.println("4. Eliminar");
		System.out.println("0. Salir");
	}

	public static void mostrarSubMenuFacturacion() {

		System.out.println("*** Menu Gestion Facturacion");
		System.out.println("1. Crear");
		System.out.println("2. Buscar");
		System.out.println("0. Salir");
	}

	public static String capturarCadenaCaracteres(String mensaje) {
		String resultado;
		while (true) {
			resultado = teclado.nextLine().strip();

			if (!resultado.isEmpty()) {
				return resultado;

			}

			System.out.println("MENSAJE: Ha escrito una cadena vacia. Especifique un valor concreto");
		}

	}

	public static int capturarNumeroEntero(String mensaje) {

		while (true) {
			try {

				System.out.printf("%s: ", mensaje);
				return Integer.parseInt(teclado.nextLine());

			} catch (NumberFormatException e) {

				System.out.println("MENSAJE: Digite un valor que corresponda con un numero entero");
			}

		}
	}

	public static double capturarNumeroReal(String mensaje) {

		while (true) {
			try {

				System.out.printf("%s: ", mensaje);
				return Double.parseDouble(teclado.nextLine());

			} catch (NumberFormatException e) {

				System.out.println("MENSAJE: Digite un valor que corresponda con un numero entero");
			}

		}
	}

}