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
    private Date fechasolicitud;
    private float cantidadresiduo;
    private boolean asignado;
    private Destino destino;

  
    
    public SolicitudTraslado() {
    }

    public SolicitudTraslado(ObjectId id, String codigo, Residuo residuo, Date fechasolicitud, float cantidadresiduo, boolean asignado, Destino destino) {
        this.id = id;
        this.codigo = codigo;
        this.residuo = residuo;
        this.fechasolicitud = fechasolicitud;
        this.cantidadresiduo = cantidadresiduo;
        this.asignado = asignado;
        this.destino = destino;
    }

    public SolicitudTraslado(String codigo, Residuo residuo, Date fechasolicitud, float cantidadresiduo, boolean asignado, Destino destino) {
        this.codigo = codigo;
        this.residuo = residuo;
        this.fechasolicitud = fechasolicitud;
        this.cantidadresiduo = cantidadresiduo;
        this.asignado = asignado;
        this.destino = destino;
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

    public Date getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    public float getCantidadresiduo() {
        return cantidadresiduo;
    }

    public void setCantidadresiduo(float cantidadresiduo) {
        this.cantidadresiduo = cantidadresiduo;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

   
    
    
    
    
    
    
    
}
