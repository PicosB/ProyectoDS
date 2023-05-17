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
public class ConstituyenteQuimico {

    private ObjectId id;
    private String nombre;


    public ConstituyenteQuimico() {
    }

    public ConstituyenteQuimico(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ConstituyenteQuimico(String nombre) {
        this.nombre = nombre;
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

}
