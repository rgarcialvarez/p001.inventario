package aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelos.Cliente;
import modelos.Factura;
import modelos.Producto;
import modelos.Proveedor;

public class Aplicacion {

	private static final int SALIR = 0;
	private static final int GESTION_CLIENTES = 1;
	private static final int GESTION_PROVEEDORES = 2;
	private static final int GESTION_PRODUCTOS = 3;
	private static final int GESTION_FACTURACION = 4;
	
	private static final int CREAR = 1;
	private static final int BUSCAR = 2;
	private static final int ACTUALIZAR = 3;
	private static final int ELIMINAR = 4;
	
	private static Scanner teclado;

	public static void main(String[] args) {

		teclado = new Scanner(System.in);

		List<Cliente> clientes = new ArrayList<>();
		List<Proveedor> proveedores = new ArrayList<>();
		List<Producto> productos = new ArrayList<>();
		List<Factura> facturas = new ArrayList<>();

		int opcion;
		int opcionSubMenu;
		
		do {
			
			do {

				mostrarMenuPrincipal();
				opcion = capturarNumeroEntero("Digite la operacion a realizar");

				if (opcion < SALIR || opcion > GESTION_FACTURACION) {
					
					System.out.println("MENSAJE: Debe digitar un valor entre 0 y 4");
				}
				
			} while (opcion < SALIR || opcion > GESTION_FACTURACION);

			if(opcion == SALIR) {
				break;
			}
			
			switch (opcion) {
			
				case GESTION_CLIENTES: {
					
					do {

						mostrarSubMenu("Clientes");
						opcionSubMenu = capturarNumeroEntero("Digite la operacion a realizar");

						if (opcionSubMenu < SALIR || opcionSubMenu > ELIMINAR) {
							
							System.out.println("MENSAJE: Debe digitar un valor entre 0 y 4");
						}
						
					} while (opcionSubMenu < SALIR || opcionSubMenu > ELIMINAR);

					if(opcionSubMenu == SALIR) {
						break;
					}
					
					switch(opcionSubMenu) {
					
					case CREAR: {
						crearCliente(clientes);
						break;
					}
					
					case BUSCAR: {
						break;
					}
					
					case ACTUALIZAR: {
						break;
					}
					
					case ELIMINAR: {
						break;
					}
					}
					
				}
				
				case GESTION_PROVEEDORES: {
					
					mostrarSubMenu("Proveedores");
					break;
				}
				
				case GESTION_PRODUCTOS: {
					
					mostrarSubMenu("Productos");
					break;
				}
				
				case GESTION_FACTURACION: {
					
					mostrarSubMenuFacturacion();
					break;
				}
				
			}
			
		} while (opcion != SALIR);

	}

	private static void crearCliente(List<Cliente> clientes) {
		
		System.out.println("--- Crear Cliente ---");
		int numeroCedula;
		
		do {
			numeroCedula = capturarNumeroEntero("Digite el numero de cedula del cliente nuevo");

			if(numeroCedula <= 0) {
				System.out.println("MENSAJE: La cedula debe ser un numero entero positivo");
			}
			
		} while(numeroCedula <=0);
		
		
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