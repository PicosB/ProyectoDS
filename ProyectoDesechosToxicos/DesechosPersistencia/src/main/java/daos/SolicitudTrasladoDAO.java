/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import entidades.EmpresaTransportista;
import entidades.SolicitudTraslado;
import exceptions.DAOException;

/**
 *
 * @author icedo
 */
public class SolicitudTrasladoDAO extends ISolicitudTrasladoDAO {

    @Override
    public void guardar(SolicitudTraslado solicitudtraslado) throws DAOException {
        MongoCollection<SolicitudTraslado> coleccionST = this.getCollection();
        coleccionST.insertOne(solicitudtraslado);
    }

    @Override
    public SolicitudTraslado verificaExistencia(String codigo) throws DAOException {
        MongoCollection<SolicitudTraslado> coleccionST = this.getCollection();

        SolicitudTraslado solicitudEncontrada = coleccionST.find(Filters.eq("codigo", codigo)).first();

        return solicitudEncontrada;
    }

    @Override
    public void insertarEmpresaTransportista(String codigo, EmpresaTransportista empresaTransportista) throws DAOException {
        MongoCollection<SolicitudTraslado> coleccionST = this.getCollection();

        // Verificar si la solicitud de traslado existe
        SolicitudTraslado solicitudEncontrada = verificaExistencia(codigo);

        if (solicitudEncontrada != null) {
            // Insertar el objeto EmpresaTransportista en la solicitud de traslado
            solicitudEncontrada.setEmpresatransportista(empresaTransportista);

            // Guardar los cambios en la base de datos
            coleccionST.replaceOne(Filters.eq("codigo", codigo), solicitudEncontrada);
        } else {
            throw new DAOException("No se encontró la solicitud de traslado con el código " + codigo);
        }
    }

    @Override
    public MongoCollection<SolicitudTraslado> getCollection() {
        MongoDatabase db = this.getMongoDB("residuosBD");
        MongoCollection<SolicitudTraslado> colleccionSolicitudTraslado = db.getCollection("solicitudtraslado", SolicitudTraslado.class
        );
        return colleccionSolicitudTraslado;
    }

}
