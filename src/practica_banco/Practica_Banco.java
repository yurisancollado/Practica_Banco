/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_banco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Yuri
 */
public class Practica_Banco {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    static ArrayList<TipoCuenta> listaTipoCuentas = new ArrayList<TipoCuenta>();
    static ArrayList<TipoOperacion> listaTipoOperacion = new ArrayList<TipoOperacion>();

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String opcionMenu = "0";
        InputStreamReader leerCadena = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(leerCadena);
        
          while (!"5".equals(opcionMenu)) {
            mostrarMenuPrincipal();
            System.out.print("Ingrese una Opcion...   ");
            opcionMenu = buffer.readLine();

            if ("1".equals(opcionMenu)) {//Crear un Cliente
                menuCrearCliente();
            }
            if ("2".equals(opcionMenu)) {//Abrir Cuenta Bancaria
                menuAbrirCuentaBancaria();
            }
            if ("3".equals(opcionMenu)) {//Realizar Operaciones Bancaria
                menuRealizarOperacionBancaria();
            }
            if ("4".equals(opcionMenu)) {//Reportes
                menuReportes();
            }
        }
        System.out.println("Fin.");
        
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("----------- Menu Principal -------------------");
        System.out.println("1. Crear un Cliente");
        System.out.println("2. Abrir Cuenta Bancaria");
        System.out.println("3. Realizar Operaciones Bancaria");
        System.out.println("4. Reportes");
        System.out.println("5. Salir");
        System.out.println("----------------------------------------------");
    }
   private static void mostrarMenuReportes() {
        System.out.println("----------- Menu Reporte -------------------");
        System.out.println("1. Consultar Usuario.");
        System.out.println("2. Consultar Cuenta Bancaria.");
        System.out.println("3. Listado de Cliente.");
        System.out.println("4. Listado de cuentas por tipos.");
        System.out.println("5. Listado de tipos de Operaciones.");
        System.out.println("6. Listado de tipos de Cuenta.");
        System.out.println("7. Salir al Menu Principal.");
        System.out.println("----------------------------------------------");
    }
    
    private static void menuReportes() throws IOException {
         String opcionMenu = "0";
        InputStreamReader leerCadena = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(leerCadena);
        while (!"7".equals(opcionMenu)) {
            mostrarMenuReportes();
            System.out.print("Ingrese una Opcion...   ");
            opcionMenu = buffer.readLine();
            if ("1".equals(opcionMenu)) { //Consultar Usuario
                reporteConsultarCliente();
            }
            if ("2".equals(opcionMenu)) { //Consultar Cuenta Bancaria
                reporteConsultarCuentaBancaria();
            }
            if ("3".equals(opcionMenu)) { //Listado de Cliente
                reporteListadoCliente();
            }
             if ("4".equals(opcionMenu)) { //Listado de cuentas por tipos.
                reporteListadoCuentaPorTipo();
            }
            if ("5".equals(opcionMenu)) { //Listado de Tipo de Operacion
                reporteListadoTipoOperacion();
            }
            if ("6".equals(opcionMenu)) { //Tipos de Cuenta
                reporteListadoTipoCuenta();
            }
        }
    }

    private static void menuRealizarOperacionBancaria() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void menuAbrirCuentaBancaria() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void menuCrearCliente() throws IOException {
        InputStreamReader leerCadena = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(leerCadena);
        String nombre, cedula;
        Cliente cl = new Cliente();
        System.out.println("----------- Crear Cliente -------------------");
        System.out.print("Ingresar Nombre Cliente:  ");
        nombre = buffer.readLine();
        System.out.println("");
        System.out.print("Ingresar Cedula Cliente:  ");
        cedula = buffer.readLine();
        cl.createCliente(nombre, cedula);
        listaCliente.add(cl);
        System.out.println("Cliente Agregado.");
    }

    private static void reporteListadoTipoCuenta() {
        throw new UnsupportedOperationException("Not yet implemented");
    }



    private static void reporteConsultarCliente() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void reporteConsultarCuentaBancaria() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void reporteListadoCliente() {
        System.out.println("----------- Listado Cliente -------------------");
        for (Iterator it = listaCliente.iterator(); it.hasNext();) {
            Cliente c = (Cliente) it.next();
            c.imprimirDatosCliente();
        }
    }

    private static void reporteListadoCuentaPorTipo() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void reporteListadoTipoOperacion() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    
}
