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
public class Vehiculo {
    
    private ObjectId id;
    
    private String tipo;
    
    private EmpresaTransportista empresatransportista;

    public Vehiculo() {
    }

    public Vehiculo(ObjectId id, String tipo, EmpresaTransportista empresatransportista) {
        this.id = id;
        this.tipo = tipo;
        this.empresatransportista = empresatransportista;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EmpresaTransportista getEmpresatransportista() {
        return empresatransportista;
    }

    public void setEmpresatransportista(EmpresaTransportista empresatransportista) {
        this.empresatransportista = empresatransportista;
    }

    
    
    
    
    
    
    
    
}
