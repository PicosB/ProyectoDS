/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import entidades.EmpresaTransportista;
import entidades.SolicitudTraslado;
import exceptions.DAOException;
import org.bson.conversions.Bson;

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
    public SolicitudTraslado obtienePorNombre(String nombre) throws DAOException {
        MongoCollection<SolicitudTraslado> coleccionST = this.getCollection();

        SolicitudTraslado solicitudEncontrada = coleccionST.find(Filters.eq("nombre", nombre)).first();

        return solicitudEncontrada;
    }
    @Override
    public void marcarAsignado(String codigo) throws DAOException {
        MongoCollection<SolicitudTraslado> coleccionST = this.getCollection();

        // Crea un filtro para encontrar la solicitud de traslado por su identificador
        Bson filtro = Filters.eq("codigo", codigo);

        // Crea un objeto de actualización para marcar el atributo "asignado" como true
        Bson actualizacion = Updates.set("asignado", true);

        // Ejecuta la operación de actualización
        UpdateResult resultado = coleccionST.updateOne(filtro, actualizacion);

        if (resultado.getModifiedCount() != 1) {
            throw new DAOException("No se pudo actualizar la solicitud de traslado");
        }
    }
    
    @Override
    public void asignarEmpresaTransportista(String codigo, EmpresaTransportista empresatransportista) throws DAOException {
    MongoCollection<SolicitudTraslado> coleccionST = this.getCollection();

    // Crea un filtro para encontrar la solicitud de traslado por su identificador
    Bson filtro = Filters.eq("codigo", codigo);

    // Crea un objeto de actualización para asignar la empresa transportista a la solicitud de traslado
    Bson actualizacion = Updates.set("empresatransportista", empresatransportista);

    // Ejecuta la operación de actualización
    UpdateResult resultado = coleccionST.updateOne(filtro, actualizacion);

    if (resultado.getModifiedCount() != 1) {
        throw new DAOException("No se pudo asignar la empresa transportista a la solicitud de traslado");
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
