/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_banco;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Yuri
 */
public class OperacionBancaria {
    static long totalOperacion = 1;
    private String claveOperacion;
    private Date fechaOperacion;
    private long montoOperacion;
    private long idOperacion;
    private TipoOperacion tipoOperacion;
    public void createOperationBancaria(String cla, long mont, TipoOperacion tipo) {
        claveOperacion = cla;
        fechaOperacion = new Date();
        montoOperacion = mont;
        idOperacion = totalOperacion;
        tipoOperacion = tipo;
        totalOperacion++;
    }

    public void getListOperacionesByDate(Date fec) {
        if (fechaOperacion == fec) {
            System.out.println("#" + idOperacion + "    Monto: " + montoOperacion);
        }
    }

    public void imprimirOperacion() {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyy");
    }
}
