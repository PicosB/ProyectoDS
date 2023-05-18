/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Residuo;
import entidades.EmpresaTransportista;
import entidades.SolicitudTraslado;
import entidades.Traslado;
import exceptions.DAOException;
/**
 *
 * @author xfs85
 */
public class Fachada {
    private final IResiduoDAO residuoDAO;
    private final ITrasladoDAO trasladoDAO;
    private final ISolicitudTrasladoDAO solicitudTrasladoDAO;

    public Fachada() {
        this.residuoDAO = new ResiduoDAO();
        this.trasladoDAO = new TrasladoDAO();
        this.solicitudTrasladoDAO = new SolicitudTrasladoDAO();
    }

    // Métodos para Residuo

    public void crearResiduo(Residuo residuo) throws DAOException {
        residuoDAO.guardar(residuo);
    }

    public Residuo verificarExistenciaResiduo(String codigo) throws DAOException {
        return residuoDAO.verificaExistencia(codigo);
    }

    public Residuo verificarExistenciaResiduoPorNombre(String nombre) throws DAOException {
        return residuoDAO.verificaExistenciaPorNombre(nombre);
    }

    // Métodos para Traslado

    public void crearTraslado(Traslado traslado) throws DAOException {
        trasladoDAO.guardar(traslado);
    }

    public Traslado verificarExistenciaTraslado(String codigo) throws DAOException {
        return trasladoDAO.verificaExistencia(codigo);
    }

    // Métodos para Solicitud de Traslado

    public void crearSolicitudTraslado(SolicitudTraslado solicitudTraslado) throws DAOException {
        solicitudTrasladoDAO.guardar(solicitudTraslado);
    }

    public SolicitudTraslado verificarExistenciaSolicitudTraslado(String codigo) throws DAOException {
        return solicitudTrasladoDAO.verificaExistencia(codigo);
    }

    public SolicitudTraslado obtenerSolicitudTrasladoPorNombre(String nombre) throws DAOException {
        return solicitudTrasladoDAO.obtienePorNombre(nombre);
    }

    public void marcarAsignadoSolicitudTraslado(String codigo) throws DAOException {
        solicitudTrasladoDAO.marcarAsignado(codigo);
    }

    public void asignarEmpresaTransportistaSolicitudTraslado(String codigo, EmpresaTransportista empresaTransportista) throws DAOException {
        solicitudTrasladoDAO.asignarEmpresaTransportista(codigo, empresaTransportista);
    }
    
  
}


