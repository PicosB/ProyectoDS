/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public interface IFabricaDatos {
    Residuo crearResiduo(String codigo, String nombre, ConstituyenteQuimico constituyenteQuimicoPrimario, ConstituyenteQuimico constituyenteQuimicoSecundario, EmpresaProductora empresaproductora );
    SolicitudTraslado crearSolicitud(String codigo, List<Residuo> residuo, LocalDate fechasolicitud, float cantidadresiduo, boolean asignado, Destino destino, EmpresaTransportista empresatransportista);
}
