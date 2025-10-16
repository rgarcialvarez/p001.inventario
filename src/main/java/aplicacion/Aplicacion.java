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
		Cliente cliente;
		
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
						cliente = crearCliente(clientes);
						clientes.add(cliente);
						break;
					}
					
					case BUSCAR: {
						cliente = buscarCliente(clientes);
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

	private static Cliente buscarCliente(List<Cliente> clientes) {

		int numeroCedula;
		String cedula;
		Cliente cliente;
		
		do {
			numeroCedula = capturarNumeroEntero("Digite el numero de cedula del cliente nuevo");

			if(numeroCedula <= 0) {
				System.out.println("MENSAJE: La cedula debe ser un numero entero positivo");
				numeroCedula = 0;
				continue;
			}
			
			cedula = String.valueOf(numeroCedula);
			
			cliente = buscarClientePorCedula(clientes, cedula);
			
			if(cliente != null) {
				System.out.printf("MENSAJE: Ya existe otro cliente con este numero de cedula: %s.\n", numeroCedula);
				numeroCedula = 0;
			}
			
		} while(numeroCedula <=0);

		return null;
	}

	private static Cliente crearCliente(List<Cliente> clientes) {
		
		System.out.println("--- Crear Cliente ---");
				
		int numeroCedula;
		String cedula="";
		int numeroTelefono;
		String telefono;
		Cliente cliente;
		
		do {
			numeroCedula = capturarNumeroEntero("Digite el numero de cedula del cliente nuevo");

			if(numeroCedula <= 0) {
				System.out.println("MENSAJE: La cedula debe ser un numero entero positivo");
				numeroCedula = 0;
				continue;
			}
			
			cedula = String.valueOf(numeroCedula);
			
			cliente = buscarClientePorCedula(clientes, cedula);
			
			if(cliente != null) {
				System.out.printf("MENSAJE: Ya existe otro cliente con este numero de cedula: %s.\n", numeroCedula);
				numeroCedula = 0;
			}
			
		} while(numeroCedula <=0);
		
		String nombre  = capturarCadenaCaracteres("Digite los nombres del cliente nuevo");
		String apellido  = capturarCadenaCaracteres("Digite los apellidos del cliente nuevo");
		
		do {
			
		 numeroTelefono = capturarNumeroEntero("MENSAJE: Digite el numero de telefono del cliente nuevo");	
		 
		 
		 if(numeroTelefono <=0) {
			 System.out.println("MENSAJE: El numero de telefono debe ser valor positivo");
		 }
		 
		 telefono = String.valueOf(numeroTelefono);
		 
		} while(numeroTelefono <=0);
		
		String direccion  = capturarCadenaCaracteres("Digite la direccion del cliente nuevo");

		String correoElectronico;
		
		while(true) {
			
			correoElectronico = capturarCadenaCaracteres("Digite el correo electronico del cliente nuevo");
			
			if(!correoElectronicoValido(correoElectronico)) {
				System.out.println("MENSAJE: Ha digitado un valor que no corresponde con un correo electronico");
				continue;
			}
			break;
		}
		
		cliente = new Cliente(cedula, nombre, apellido, telefono, direccion, correoElectronico);
		
		return cliente;
	}

	
	private static Cliente buscarClientePorCedula(List<Cliente> clientes, String cedula) {
		
		for (Cliente cliente : clientes) {
			if(cliente.getCedula().equals(cedula)) {
				return cliente;
			}
		}				
		return null;
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
	
	static boolean correoElectronicoValido(String correo) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return correo.matches(regex);
	}
	

}