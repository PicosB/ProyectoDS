/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import entidades.Residuo;
import exceptions.DAOException;
import java.util.ArrayList;
import org.bson.types.ObjectId;

/**
 *
 * @author icedo
 */
public class ResiduoDAO extends IResiduoDAO<Residuo>{

    @Override
    public void guardar(Residuo entidad) {
        MongoCollection<Residuo> coleccionR = this.getCollection();
        coleccionR.insertOne(entidad);
    }

   

    @Override
    public MongoCollection<Residuo> getCollection() {
        MongoDatabase db = this.getMongoDB("residuosBD");
        MongoCollection<Residuo> colleccionResiduos = db.getCollection("residuo", Residuo.class);
        return colleccionResiduos;
    }
    
    
    
}
