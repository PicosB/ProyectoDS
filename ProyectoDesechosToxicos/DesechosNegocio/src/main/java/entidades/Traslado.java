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
    
    private float kilometros, costo;
    
    private Date fechaLlegada;
    
    private Destino destino;

    private Residuo residuo;
    
    public Traslado() {
    }

    public Traslado(ObjectId id, float kilometros, float costo, Date fechaLlegada, Destino destino, Residuo residuo) {
        this.id = id;
        this.kilometros = kilometros;
        this.costo = costo;
        this.fechaLlegada = fechaLlegada;
        this.destino = destino;
        this.residuo = residuo;
    }

    public Traslado(float kilometros, float costo, Date fechaLlegada, Destino destino, Residuo residuo) {
        this.kilometros = kilometros;
        this.costo = costo;
        this.fechaLlegada = fechaLlegada;
        this.destino = destino;
        this.residuo = residuo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    

   
    
    
    
    
}
