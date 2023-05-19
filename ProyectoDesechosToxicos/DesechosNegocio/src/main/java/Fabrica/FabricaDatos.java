/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabrica;

import entidades.ConstituyenteQuimico;
import entidades.Destino;
import entidades.EmpresaProductora;
import entidades.EmpresaTransportista;
import entidades.Residuo;
import entidades.SolicitudTraslado;
import java.time.LocalDate;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author xfs85
 */
public class FabricaDatos implements IFabricaDatos {

    @Override
    public Residuo crearResiduo(String codigo, String nombre, ConstituyenteQuimico constituyenteQuimicoPrimario, ConstituyenteQuimico constituyenteQuimicoSecundario, EmpresaProductora empresaproductora) {
        return new Residuo(codigo, nombre, constituyenteQuimicoPrimario, constituyenteQuimicoSecundario, empresaproductora);
    }

    @Override
    public SolicitudTraslado crearSolicitud(String codigo, List<Residuo> residuo, LocalDate fechasolicitud, float cantidadresiduo, boolean asignado, Destino destino, EmpresaTransportista empresatransportista) {
        return new SolicitudTraslado(codigo, residuo, fechasolicitud, cantidadresiduo, asignado, destino, empresatransportista);
    }
    
    
    
}
