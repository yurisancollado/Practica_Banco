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
public class TipoCuenta {
    private String descripcion;
    private long idTipocuenta;
    static long totalTipoCuenta=1;
    private ArrayList<CuentaBancaria> listaCuentaBancaria =new ArrayList<CuentaBancaria>();

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdTipocuenta() {
        return idTipocuenta;
    }

    public void setIdTipocuenta(long idTipocuenta) {
        this.idTipocuenta = idTipocuenta;
    }

    public ArrayList<CuentaBancaria> getListaCuentaBancaria() {
        return listaCuentaBancaria;
    }

    public void setListaCuentaBancaria(ArrayList<CuentaBancaria> listaCuentaBancaria) {
        this.listaCuentaBancaria = listaCuentaBancaria;
    }

    public static long getTotalTipoCuenta() {
        return totalTipoCuenta;
    }

    public static void setTotalTipoCuenta(long totalTipoCuenta) {
        TipoCuenta.totalTipoCuenta = totalTipoCuenta;
    }

    
    
    void imprimirDatoCuenta() {
        System.out.println("#"+idTipocuenta+"    "+descripcion);
    }

    public void addCuentaBancaria(CuentaBancaria cuenta){
        listaCuentaBancaria.add(cuenta);
    }

    public void addTipoCuenta(String desc){
        descripcion = desc;
        idTipocuenta=totalTipoCuenta;
        totalTipoCuenta++;
    }

    
}
