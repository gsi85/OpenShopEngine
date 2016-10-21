package com.openshop.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import javax.inject.Named;

/**
 * @author Laszlo_Sisa
 */
@Named("databaseConnectionHolder")
public class MongoDatabaseConnectionHolder {

    private final MongoDatabase database;

    //TODO: extract these to config
    private final String databaseName = "openShop";
    private final String databaseHost = "localhost";
    private final int databasePort = 27017;

    public MongoDatabaseConnectionHolder() {
        MongoClient mongoClient = new MongoClient(databaseHost, databasePort);
        database = mongoClient.getDatabase(databaseName);
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
