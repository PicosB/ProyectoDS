/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import org.bson.types.ObjectId;

/**
 *
 * @author icedo
 */
public class Destino {
    
    private ObjectId id;
    private String nombre, tratamiento;

    public Destino() {
    }

    public Destino(ObjectId id, String nombre, String tratamiento) {
        this.id = id;
        this.nombre = nombre;
        this.tratamiento = tratamiento;
    }

    public Destino(String nombre, String tratamiento) {
        this.nombre = nombre;
        this.tratamiento = tratamiento;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    
    
    
    
    
}
