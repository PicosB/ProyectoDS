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
public class TrasladoPorPartes extends Traslado{

    private Vehiculo vehiculo;
    
    
    public TrasladoPorPartes() {
    }

    public TrasladoPorPartes(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public TrasladoPorPartes(ObjectId id, float kilometros, float costo, Date fechaLlegada, Destino destino, Residuo residuo, Vehiculo vehiculo) {
        super(id, kilometros, costo, fechaLlegada, destino, residuo);
        this.vehiculo = vehiculo;
    }

    public TrasladoPorPartes(float kilometros, float costo, Date fechaLlegada, Destino destino, Residuo residuo, Vehiculo vehiculo) {
        super(kilometros, costo, fechaLlegada, destino, residuo);
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    
   

    
    
    
    
    
    
}
