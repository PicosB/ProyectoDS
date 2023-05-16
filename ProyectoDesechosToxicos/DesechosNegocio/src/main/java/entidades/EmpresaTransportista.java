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
public class EmpresaTransportista extends Empresa{
    
   
    
    public EmpresaTransportista() {
    }

    public EmpresaTransportista(ObjectId id, String nombre) {
        super(id, nombre);
    }

    public EmpresaTransportista(String nombre) {
        super(nombre);
    }
    
    
    
    
}
