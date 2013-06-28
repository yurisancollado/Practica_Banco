/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_banco;

import java.util.ArrayList;

/**
 *
 * @author Yuri
 */
public class Cliente {
    static long totalcliente = 1000;
    private long idCliente;
    private String nombreCliente;
    private String cedulaCliente;
    private ArrayList<CuentaBancaria> listaCuentaBancaria = new ArrayList<CuentaBancaria>();

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<CuentaBancaria> getListaCuentaBancaria() {
        return listaCuentaBancaria;
    }

    public void setListaCuentaBancaria(ArrayList<CuentaBancaria> listaCuentaBancaria) {
        this.listaCuentaBancaria = listaCuentaBancaria;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public static long getTotalcliente() {
        return totalcliente;
    }

    public static void setTotalcliente(long totalcliente) {
        Cliente.totalcliente = totalcliente;
    }
    
    
    
    
    void createCliente(String nombre, String cedula) {
        nombreCliente = nombre;
        cedulaCliente = cedula;
        idCliente = totalcliente;
        totalcliente++;
    }

    void imprimirDatosCliente() {
        System.out.println("#" + idCliente + " C.I. " + cedulaCliente + "   " + nombreCliente);
    }

    boolean buscarClientebyCedula(String cedula) {
        if (cedula.equals(cedulaCliente)) {
            return true;
        }
        return false;
    }

    public void addCuentaBancaria(CuentaBancaria cuenta) {
        listaCuentaBancaria.add(cuenta);
    }

    public void imprimirCuentasBancaria(){
        for (int i = 0; i < listaCuentaBancaria.size(); i++) {
            System.out.println("#"+listaCuentaBancaria.get(i).getNumeroCuenta()+" - "+listaCuentaBancaria.get(i).getTipoCuenta().getDescripcion()+"    $"+listaCuentaBancaria.get(i).getSaldo());
            
        }
    }
     public boolean  buscarCuentaBancaria(String numeroCuenta){
        CuentaBancaria cuenta=null;
        for (int i = 0; i < listaCuentaBancaria.size(); i++) {
           if(listaCuentaBancaria.get(i).getNumeroCuenta().equals(numeroCuenta)){
              return  true;
           }            
        }        
        return false;
    }
      public boolean realizarRetiro(String cuenta, long saldo, TipoOperacion tipoOperacion){
        for (int i = 0; i < listaCuentaBancaria.size(); i++) {
          if(listaCuentaBancaria.get(i).getNumeroCuenta().equals(cuenta)){ 
             return  listaCuentaBancaria.get(i).retirarDinero(saldo, tipoOperacion);
          }            
        }
        return false;
    }
    public boolean realizarDeposito(String cuenta, long saldo, TipoOperacion tipoOperacion){
        for (int i = 0; i < listaCuentaBancaria.size(); i++) {
          if(listaCuentaBancaria.get(i).getNumeroCuenta().equals(cuenta)){ 
             return  listaCuentaBancaria.get(i).depositoDinero(saldo, tipoOperacion);
          }            
        }
        return false;
    }
    public boolean imprimirCuentaBancaria(String numeroCuenta){
        for (int i = 0; i < listaCuentaBancaria.size(); i++) {
            if(listaCuentaBancaria.get(i).getNumeroCuenta().equals(numeroCuenta)){
                listaCuentaBancaria.get(i).imprimirInformacion();
                return true;
            }            
        }
        return false;
    }
}
