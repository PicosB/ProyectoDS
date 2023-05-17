/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import entidades.Residuo;
import exceptions.DAOException;

/**
 *
 * @author icedo
 */
public class ResiduoDAO extends IResiduoDAO {

    @Override
    public void guardar(Residuo residuo) throws DAOException {
        MongoCollection<Residuo> coleccionR = this.getCollection();
        coleccionR.insertOne(residuo);
    }

    @Override
    public Residuo verificaExistencia(String codigo) throws DAOException {
        MongoCollection<Residuo> coleccionR = this.getCollection();

        Residuo residuoEncontrado = coleccionR.find(Filters.eq("codigo", codigo)).first();

        return residuoEncontrado;
    }

    @Override
    public Residuo verificaExistenciaPorNombre(String nombre) throws DAOException {
        MongoCollection<Residuo> coleccionR = this.getCollection();

        Residuo residuoEncontrado = coleccionR.find(Filters.eq("nombre", nombre)).first();

        return residuoEncontrado;
    }

    @Override
    public MongoCollection<Residuo> getCollection() {
        MongoDatabase db = this.getMongoDB("residuosBD");
        MongoCollection<Residuo> colleccionResiduos = db.getCollection("residuo", Residuo.class);
        return colleccionResiduos;
    }

}
