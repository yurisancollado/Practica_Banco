/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_banco;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Yuri
 */
public class CuentaBancaria {
    static long totalCuentaBancaria = 1;
    private Date fechaApertura;
    private long idCuentaBancaria;
    private String numeroCuenta;
    private long saldo;
    private TipoCuenta tipoCuenta;
    private ArrayList<OperacionBancaria> listaOperacionBancaria = new ArrayList<OperacionBancaria>();

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public long getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(long idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public ArrayList<OperacionBancaria> getListaOperacionBancaria() {
        return listaOperacionBancaria;
    }

    public void setListaOperacionBancaria(ArrayList<OperacionBancaria> listaOperacionBancaria) {
        this.listaOperacionBancaria = listaOperacionBancaria;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public static long getTotalCuentaBancaria() {
        return totalCuentaBancaria;
    }

    public static void setTotalCuentaBancaria(long totalCuentaBancaria) {
        CuentaBancaria.totalCuentaBancaria = totalCuentaBancaria;
    }

    
    
    public void createCuentaBancaria(String numero, long sald, TipoCuenta tipo) {
        fechaApertura = new Date();
        numeroCuenta = numero;
        saldo = sald;
        idCuentaBancaria = totalCuentaBancaria;
        totalCuentaBancaria++;
        tipoCuenta = tipo;
    }
     public void imprimirInformacion() {
        System.out.println("Numero de Cuenta: "+numeroCuenta);
        System.out.println("Saldo: "+saldo);
        System.out.println("Operaciones Bancaria");
        for (int i = 0; i < listaOperacionBancaria.size(); i++) {
            listaOperacionBancaria.get(i).imprimirOperacion();            
        }
    }
    public boolean retirarDinero(long sald,TipoOperacion tipooperacion) {
        if (saldo >= sald) {
            saldo -= sald;
            OperacionBancaria operacion=new OperacionBancaria();
            operacion.createOperationBancaria(numeroCuenta, sald, tipooperacion);
            listaOperacionBancaria.add(operacion);
            System.out.println("Saldo Actual:  $"+saldo);
            return true;
        }else
            System.out.println("Saldo Insuficiente.");
        return false;
    }
    public boolean depositoDinero(long sald,TipoOperacion tipooperacion){
            saldo += sald;
            OperacionBancaria operacion=new OperacionBancaria();
            operacion.createOperationBancaria(numeroCuenta, sald, tipooperacion);
            listaOperacionBancaria.add(operacion);
            System.out.println("Saldo Actual:  $"+saldo);
            return true;
    }

}
