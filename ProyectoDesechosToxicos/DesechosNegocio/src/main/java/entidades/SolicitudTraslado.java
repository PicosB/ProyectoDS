/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author icedo
 */
public class SolicitudTraslado {
    
    private ObjectId id;
    private String codigo;
    private Residuo residuo;
    private Date fechaSolicitud;
    private int cantidadresiduo;
    private Productor productor;

  
    
    public SolicitudTraslado() {
    }

    public SolicitudTraslado(ObjectId id, String codigo, Residuo residuo, Date fechaSolicitud, int cantidadresiduo, Productor productor) {
        this.id = id;
        this.codigo = codigo;
        this.residuo = residuo;
        this.fechaSolicitud = fechaSolicitud;
        this.cantidadresiduo = cantidadresiduo;
        this.productor = productor;
    }

    public SolicitudTraslado(String codigo, Residuo residuo, Date fechaSolicitud, int cantidadresiduo, Productor productor) {
        this.codigo = codigo;
        this.residuo = residuo;
        this.fechaSolicitud = fechaSolicitud;
        this.cantidadresiduo = cantidadresiduo;
        this.productor = productor;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getCantidadresiduo() {
        return cantidadresiduo;
    }

    public void setCantidadresiduo(int cantidadresiduo) {
        this.cantidadresiduo = cantidadresiduo;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

   
    
    
    
    
    
    
    
}
