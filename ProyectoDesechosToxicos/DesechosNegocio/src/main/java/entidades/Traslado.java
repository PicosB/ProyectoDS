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
public class Traslado {
    
    private ObjectId id;
    
    private String codigo;
    
    private float kilometros, costo;
    
    private Date fechaLlegada;
    
    private String tratamiento;
    
    private SolicitudTraslado solicitudtraslado;
    
    private Vehiculo vehiculo;
    
    public Traslado() {
    }

    public Traslado(ObjectId id, String codigo, float kilometros, float costo, Date fechaLlegada, String tratamiento, SolicitudTraslado solicitudtraslado, Vehiculo vehiculo) {
        this.id = id;
        this.codigo = codigo;
        this.kilometros = kilometros;
        this.costo = costo;
        this.fechaLlegada = fechaLlegada;
        this.tratamiento = tratamiento;
        this.solicitudtraslado = solicitudtraslado;
        this.vehiculo = vehiculo;
    }

    public Traslado(String codigo, float kilometros, float costo, Date fechaLlegada, String tratamiento, SolicitudTraslado solicitudtraslado, Vehiculo vehiculo) {
        this.codigo = codigo;
        this.kilometros = kilometros;
        this.costo = costo;
        this.fechaLlegada = fechaLlegada;
        this.tratamiento = tratamiento;
        this.solicitudtraslado = solicitudtraslado;
        this.vehiculo = vehiculo;
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
    
    public float getKilometros() {
        return kilometros;
    }

    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public SolicitudTraslado getSolicitudtraslado() {
        return solicitudtraslado;
    }

    public void setSolicitudtraslado(SolicitudTraslado solicitudtraslado) {
        this.solicitudtraslado = solicitudtraslado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    

    
}
