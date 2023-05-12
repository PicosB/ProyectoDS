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
public class ResiduoDAO extends BaseDAO<Residuo>{

    @Override
    public void guardar(Residuo entidad) {
        MongoCollection<Residuo> coleccionR = this.getCollection();
        coleccionR.insertOne(entidad);
    }

    @Override
    public void eliminar(Residuo entidad) throws DAOException {
        MongoCollection<Residuo> coleccionR = this.getCollection();
        coleccionR.deleteOne(Filters.eq("_id", entidad.getId()));
    }

    @Override
    public void actualizar(Residuo entidad) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Residuo buscarPorID(ObjectId id) {
       MongoCollection coleccion = getCollection();
        Residuo r = (Residuo) coleccion.find(Filters.eq("_id", id)).first();
        return r;
    }

    @Override
    public ArrayList<Residuo> buscarTodos() {
        MongoCollection<Residuo> coleccionR = this.getCollection();
        MongoCursor<Residuo> resultadoConsulta = coleccionR.find().iterator();
        ArrayList<Residuo> listaR = new ArrayList<>();
        while (resultadoConsulta.hasNext()) {
            listaR.add(resultadoConsulta.next());
        }
        return listaR;
    }

    @Override
    public MongoCollection<Residuo> getCollection() {
        MongoDatabase db = this.getMongoDB("residuosBD");
        MongoCollection<Residuo> colleccionResiduos = db.getCollection("residuo", Residuo.class);
        return colleccionResiduos;
    }
    
    
    
}
