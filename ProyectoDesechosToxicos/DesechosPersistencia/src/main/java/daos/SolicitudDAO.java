/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Traslado;
import exceptions.DAOException;

/**
 *
 * @author icedo
 */
public class SolicitudDAO extends ISolicitudDAO {

    @Override
    public void guardar(Traslado traslado) throws DAOException {
        MongoCollection<Traslado> coleccionR = this.getCollection();
        coleccionR.insertOne(traslado);
    }
    
    @Override
    public MongoCollection<Traslado> getCollection() {
        MongoDatabase db = this.getMongoDB("residuosBD");
        MongoCollection<Traslado> colleccionResiduos = db.getCollection("traslado", Traslado.class
        );
        return colleccionResiduos;
    }
    
}
