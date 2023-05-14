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
public class Productor {
    
    private ObjectId id;
    
    private String usuario;
    
    private String contraseña;
    
    private String nombre;
    
    private EmpresaProductora empresaproductora;

    
    
    
    public Productor() {
    }

    
    public Productor(ObjectId id, String usuario, String contraseña, String nombre, EmpresaProductora empresaproductora) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.empresaproductora = empresaproductora;
    }

    public Productor(String usuario, String contraseña, String nombre, EmpresaProductora empresaproductora) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.empresaproductora = empresaproductora;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EmpresaProductora getEmpresaproductora() {
        return empresaproductora;
    }

    public void setEmpresaproductora(EmpresaProductora empresaproductora) {
        this.empresaproductora = empresaproductora;
    }
    
    
    
    
    
    
}
