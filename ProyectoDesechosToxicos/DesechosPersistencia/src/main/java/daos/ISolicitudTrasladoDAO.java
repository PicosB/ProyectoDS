/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.SolicitudTraslado;
import exceptions.DAOException;
import org.bson.codecs.configuration.CodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author icedo
 */
public abstract class ISolicitudTrasladoDAO {
    
    public MongoClient getConexionMongoClient() {
        //Creamos un proveedor de codecs para las clases POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        //Creamos la configuración del cliente de MongoDB      
        MongoClient mongoC = new MongoClient("localhost",MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        return mongoC;
    }

    public MongoDatabase getMongoDB(String nomBD) {
        return getConexionMongoClient().getDatabase(nomBD);
    }
    
     public abstract void guardar(SolicitudTraslado solicitudtraslado) throws DAOException;

   
    public abstract SolicitudTraslado verificaExistencia(String codigo) throws DAOException;

    public abstract MongoCollection<SolicitudTraslado> getCollection();
    
    
    
}
