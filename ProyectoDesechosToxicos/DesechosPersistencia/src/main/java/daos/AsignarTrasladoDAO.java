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
import entidades.Traslado;
import entidades.Vehiculo;
import exceptions.DAOException;
import org.bson.conversions.Bson;

/**
 *
 * @author icedo
 */
public class AsignarTrasladoDAO extends IAsignarTrasladoDAO {

    @Override
    public void guardar(Traslado traslado) throws DAOException {
        MongoCollection<Traslado> coleccionT = this.getCollection();
        coleccionT.insertOne(traslado);
    }

    @Override
    public Traslado verificaExistencia(String codigo) throws DAOException {
        MongoCollection<Traslado> coleccionT = this.getCollection();

        Traslado trasladoEncontrado = coleccionT.find(Filters.eq("codigo", codigo)).first();

        return trasladoEncontrado;
    }

    @Override
    public void agregarVehiculo(String codigo, Vehiculo vehiculo) throws DAOException {
    MongoCollection<Traslado> coleccionAT = this.getCollection();

    // Crea un filtro para encontrar la asignación de traslado por su código
    Bson filtro = Filters.eq("codigo", codigo);

    // Crea un objeto de actualización para agregar el vehículo a la colección existente
    Bson actualizacion = Updates.addToSet("vehiculo", vehiculo);

    // Ejecuta la operación de actualización
    UpdateResult resultado = coleccionAT.updateOne(filtro, actualizacion);

    if (resultado.getModifiedCount() != 1) {
        throw new DAOException("No se pudo agregar el vehículo a la asignación de traslado");
    }
}

    @Override
    public MongoCollection<Traslado> getCollection() {
        MongoDatabase db = this.getMongoDB("residuosBD");
        MongoCollection<Traslado> colleccionResiduos = db.getCollection("traslado", Traslado.class);
        return colleccionResiduos;
    }

}
