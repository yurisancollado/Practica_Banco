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
        
        //Agregar Tipo de Operaciones.
        TipoOperacion o1 = new TipoOperacion();
        o1.addTipoOperacion("Retiro",200);
        TipoOperacion o2 = new TipoOperacion();
        o2.addTipoOperacion("Deposito",500);
        TipoOperacion o3 = new TipoOperacion();
        o3.addTipoOperacion("Retiro por Cajero",100);
        listaTipoOperacion.add(o1);
        listaTipoOperacion.add(o2);
        listaTipoOperacion.add(o3);
//Agregar Tipo de Cuentas
        TipoCuenta tc1=new TipoCuenta();
        tc1.addTipoCuenta("Ahorro");
        TipoCuenta tc2=new TipoCuenta();
        tc2.addTipoCuenta("Corriente");
        TipoCuenta tc3=new TipoCuenta();
        tc3.addTipoCuenta("Maxima");
        listaTipoCuentas.add(tc1);
        listaTipoCuentas.add(tc2);
        listaTipoCuentas.add(tc3);
        //-------- Quitar --------
        Cliente c1 = new Cliente();
        c1.createCliente("Yurisan", "19878159");
        listaCliente.add(c1);
        CuentaBancaria cuen1=new CuentaBancaria();
        cuen1.createCuentaBancaria("1234", 100,tc1);
        listaCliente.get(0).addCuentaBancaria(cuen1);
        listaTipoCuentas.get(0).addCuentaBancaria(cuen1);
//---------------------
        
        
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

   public static void menuRealizarOperacionBancaria() throws IOException {
        InputStreamReader leerCadena = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(leerCadena);
        String numeroCuenta, tipoOperacion;
        System.out.println("----------- Realizar Operacion Bancaria -------------------");
        System.out.print("Ingrese el numero de Cuenta: ");
        numeroCuenta = buffer.readLine();
        System.out.println("Tipo de operacion: ");
        for (int i = 0; i < listaTipoOperacion.size(); i++) {
            listaTipoOperacion.get(i).imprimirDatosTipoOperacion();
        }
        System.out.print("Selecciona un tipo de operacion  ");
        tipoOperacion = buffer.readLine();
        System.out.println("");
        guardarNuevaOperacionBancaria(numeroCuenta, tipoOperacion);
    }

    public static void guardarNuevaOperacionBancaria(String numeroCuenta, String tipoOperacion) {
        int bol = 0;
        int posicionCliente = 0;
        long monto;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).buscarCuentaBancaria(numeroCuenta)) {
                posicionCliente = i;
                bol=1;
            }
        }
        if (bol == 0) {
            System.out.println("No se encuentra el numero de Cuenta.");
        } else {
            for (int i = 0; i < listaTipoOperacion.size(); i++) {
               if(listaTipoOperacion.get(i).getIdTipoOperacion()==Long.parseLong(tipoOperacion)){
                   monto=listaTipoOperacion.get(i).getMontoOperacion();
                   if("Retiro".equals(listaTipoOperacion.get(i).getDescripcion())){
                        if(listaCliente.get(posicionCliente).realizarRetiro(numeroCuenta, monto,listaTipoOperacion.get(i))){
                            System.out.println("Operacion procesada exitosamente. ");    
                        }else{
                            System.out.println("La operacion no puedo ser procesada.");
                        }
                   }
                   if("Deposito".equals(listaTipoOperacion.get(i).getDescripcion())){
                       if(listaCliente.get(posicionCliente).realizarDeposito(numeroCuenta, monto,listaTipoOperacion.get(i))){
                            System.out.println("Operacion procesada exitosamente. ");    
                        }else{
                            System.out.println("La operacion no puedo ser procesada.");
                        }
                   }
                   if("Retiro por Cajero".equals(listaTipoOperacion.get(i).getDescripcion())){
                        if(listaCliente.get(posicionCliente).realizarRetiro(numeroCuenta, monto,listaTipoOperacion.get(i))){
                            System.out.println("Operacion procesada exitosamente. ");    
                        }else{
                            System.out.println("La operacion no puedo ser procesada.");
                        }
                   }
               }                
            }
        }
    }
     public static void menuAbrirCuentaBancaria() throws IOException {
        InputStreamReader leerCadena = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(leerCadena);
        String cedula, opcionTCuenta, numeroCuenta;
        long saldo;
        int bol = 0;
        opcionTCuenta = "0";

        System.out.println("----------- Abrir Cuenta Bancaria -------------------");
        do {
            System.out.print("Ingrese la cedula del Cliente: ");
            cedula = buffer.readLine();

            System.out.println("Tipo de Cuenta:");
            if (listaTipoCuentas.size() > 0) {
                for (Iterator it = listaTipoCuentas.iterator(); it.hasNext();) { //Seleccionar Tipo de Cuenta
                    TipoCuenta c = (TipoCuenta) it.next();
                    c.imprimirDatoCuenta();
                }
                System.out.print("Seleccione una opcion: ");
                opcionTCuenta = buffer.readLine();
                bol = 2;
            } else {
                System.out.println("No existe Tipo de Cuenta en el sistema.");
                bol = 1;
            }

            if (bol == 2) {
                System.out.println("");
                System.out.print("Ingrese el numero de Cuenta: ");
                numeroCuenta = buffer.readLine();
                System.out.println("");
                System.out.print("Ingrese monto de apertura: ");
                saldo = Long.parseLong(buffer.readLine());
                if (guardarNuevaCuentaBancaria(cedula, numeroCuenta, Integer.parseInt(opcionTCuenta), saldo)) {
                    System.out.println("Se Almaceno exitosamente la Cuenta Bancaria");
                } else {
                    System.out.println("Error con los Datos ingresado");
                }
            }
        } while (bol == 0);

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

    public static void reporteListadoTipoCuenta() {
        System.out.println("----------- Listado Tipo Cuenta -------------------");
        for (Iterator it = listaTipoCuentas.iterator(); it.hasNext();) {
            TipoCuenta obj = (TipoCuenta) it.next();
            obj.imprimirDatoCuenta();
        }

    }



    public static void reporteConsultarCliente() throws IOException {
        InputStreamReader leerCadena = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(leerCadena);
        System.out.println("----------- Consultar Cliente -------------------");
        System.out.print("Ingrese numero de cedula: ");
        String cedula = buffer.readLine();
        boolean bol = false;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).buscarClientebyCedula(cedula)) {
                bol = true;
                System.out.println("C.I. " + cedula + "  " + listaCliente.get(i).getNombreCliente());
                System.out.println("Cuentas Bancarias:");
                listaCliente.get(i).imprimirCuentasBancaria();
            }
        }
        if (!bol) {
            System.out.println("No existe el cliente.");
        }
    }

    private static void reporteConsultarCuentaBancaria() throws IOException {
        InputStreamReader leerCadena = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(leerCadena);
        System.out.println("----------- Consultar Cuenta Bancaria -------------------");
        System.out.print("Ingrese numero de cuenta Bancaria: ");
        String numeroCuenta = buffer.readLine();
        int bol=0;
        for (int i = 0; i < listaCliente.size(); i++) {
            if(listaCliente.get(i).buscarCuentaBancaria(numeroCuenta)){
                  bol=1;  
                  System.out.println("Cliente: "+listaCliente.get(i).getNombreCliente() );
                  listaCliente.get(i).imprimirCuentaBancaria(numeroCuenta);
            }            
        }
        if(bol==0){
            System.out.println("No se encuentra la Cuenta Bancaria");
        }
    }

    private static void reporteListadoCliente() {
        System.out.println("----------- Listado Cliente -------------------");
        for (Iterator it = listaCliente.iterator(); it.hasNext();) {
            Cliente c = (Cliente) it.next();
            c.imprimirDatosCliente();
        }
    }

    private static void reporteListadoCuentaPorTipo() {
        System.out.println("----------- Listado Tipo Cuenta -------------------");
         for (int i = 0; i < listaTipoCuentas.size(); i++) {
             System.out.println("Tipo: "+listaTipoCuentas.get(i).getDescripcion());
             System.out.println("Cuentas: ");
             listaTipoCuentas.get(i).imprimirCuentasBancarias();
            
        }
    }

    public static void reporteListadoTipoOperacion() {
        System.out.println("----------- Listado Tipo Operacion -------------------");
        for (Iterator it = listaTipoOperacion.iterator(); it.hasNext();) {
            TipoOperacion obj = (TipoOperacion) it.next();
            obj.imprimirDatosTipoOperacion();
        }

    }

    public static boolean guardarNuevaCuentaBancaria(String cedula, String numeroCuenta, int opcionCuenta, Long saldo) {
        int posiCliente = -1;
        int posiTipoCuenta = -1;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).buscarClientebyCedula(cedula)) {
                posiCliente = i;
            }
        }
        for (int i = 0; i < listaTipoCuentas.size(); i++) {
            if (listaTipoCuentas.get(i).getIdTipocuenta() == opcionCuenta) {
                posiTipoCuenta = i;
            }
        }
        if (posiCliente >= 0 && posiTipoCuenta >= 0) {
            CuentaBancaria cuentabancaria = new CuentaBancaria();
            cuentabancaria.createCuentaBancaria(numeroCuenta, saldo, listaTipoCuentas.get(posiTipoCuenta));
            listaCliente.get(posiCliente).addCuentaBancaria(cuentabancaria);
            listaTipoCuentas.get(posiTipoCuenta).addCuentaBancaria(cuentabancaria);
            return true;
        }
        return false;
    }

    
}
