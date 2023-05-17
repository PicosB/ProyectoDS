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
public class Residuo {

    private ObjectId id;
    private String codigo, nombre;
    private ConstituyenteQuimico constituyenteQuimicoPrimario;

    private ConstituyenteQuimico constituyenteQuimicoSecundario;
    private EmpresaProductora empresaproductora;

    public Residuo() {
    }

    public Residuo(ObjectId id, String codigo, String nombre, ConstituyenteQuimico constituyenteQuimicoPrimario, ConstituyenteQuimico constituyenteQuimicoSecundario, EmpresaProductora empresaproductora) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.constituyenteQuimicoPrimario = constituyenteQuimicoPrimario;
        this.constituyenteQuimicoSecundario = constituyenteQuimicoSecundario;
        this.empresaproductora = empresaproductora;
    }

    public Residuo(String codigo, String nombre, ConstituyenteQuimico constituyenteQuimicoPrimario, ConstituyenteQuimico constituyenteQuimicoSecundario, EmpresaProductora empresaproductora) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.constituyenteQuimicoPrimario = constituyenteQuimicoPrimario;
        this.constituyenteQuimicoSecundario = constituyenteQuimicoSecundario;
        this.empresaproductora = empresaproductora;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ConstituyenteQuimico getConstituyenteQuimicoPrimario() {
        return constituyenteQuimicoPrimario;
    }

    public void setConstituyenteQuimicoPrimario(ConstituyenteQuimico constituyenteQuimicoPrimario) {
        this.constituyenteQuimicoPrimario = constituyenteQuimicoPrimario;
    }

    public ConstituyenteQuimico getConstituyenteQuimicoSecundario() {
        return constituyenteQuimicoSecundario;
    }

    public void setConstituyenteQuimicoSecundario(ConstituyenteQuimico constituyenteQuimicoSecundario) {
        this.constituyenteQuimicoSecundario = constituyenteQuimicoSecundario;
    }

  
    public EmpresaProductora getEmpresaproductora() {
        return empresaproductora;
    }

    public void setEmpresaproductora(EmpresaProductora empresaproductora) {
        this.empresaproductora = empresaproductora;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    

}
