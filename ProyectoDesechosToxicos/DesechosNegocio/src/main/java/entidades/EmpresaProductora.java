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
public class EmpresaProductora extends Empresa {
    
   
    
    public EmpresaProductora() {
    }

    
   

    public EmpresaProductora(ObjectId id, String nombre, String ciudad) {
        super(id, nombre, ciudad);
    }

    public EmpresaProductora(String nombre, String ciudad) {
        super(nombre, ciudad);
    }

    
    
    
    
    
}

