/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_banco;

/**
 *
 * @author Yuri
 */
public class TipoOperacion {    
    private String descripcion;
    private long idTipoOperacion;
    static long totalTipoOperacion=1;
    private long montoOperacion;

    public void addTipoOperacion(String desc,long monto){
        descripcion = desc;
        montoOperacion=monto;
        idTipoOperacion=totalTipoOperacion;
        totalTipoOperacion++;
    }

    public void imprimirDatosTipoOperacion(){
        System.out.println("#"+idTipoOperacion+"    "+descripcion+"   $"+montoOperacion);
    }
}
