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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(long idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public static long getTotalTipoOperacion() {
        return totalTipoOperacion;
    }

    public static void setTotalTipoOperacion(long totalTipoOperacion) {
        TipoOperacion.totalTipoOperacion = totalTipoOperacion;
    }

    public long getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(long montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

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
