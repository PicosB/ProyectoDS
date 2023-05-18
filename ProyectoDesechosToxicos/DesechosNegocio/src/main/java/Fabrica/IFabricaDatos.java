/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Fabrica;

import entidades.ConstituyenteQuimico;
import entidades.EmpresaProductora;
import entidades.Residuo;
import org.bson.types.ObjectId;

/**
 *
 * @author xfs85
 */
public interface IFabricaDatos {
    Residuo crearResiduo(String codigo, String nombre, ConstituyenteQuimico constituyenteQuimicoPrimario, ConstituyenteQuimico constituyenteQuimicoSecundario, EmpresaProductora empresaproductora );
}
