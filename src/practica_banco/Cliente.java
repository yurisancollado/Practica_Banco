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
}
