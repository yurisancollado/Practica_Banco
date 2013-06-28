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
}
