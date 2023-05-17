/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import entidades.Traslado;
import exceptions.DAOException;

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
    public MongoCollection<Traslado> getCollection() {
        MongoDatabase db = this.getMongoDB("residuosBD");
        MongoCollection<Traslado> colleccionResiduos = db.getCollection("traslado", Traslado.class);
        return colleccionResiduos;
    }

}
