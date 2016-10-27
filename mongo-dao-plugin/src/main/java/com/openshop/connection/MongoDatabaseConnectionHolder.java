package com.openshop.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Holds data base connection.
 *
 * @author Laszlo_Sisa
 */
public class MongoDatabaseConnectionHolder {

    private final MongoDatabase database;

    /**
     * DI constructor.
     *
     * @param databaseConfigurationFactory {@link DatabaseConfigurationFactory}.
     */
    public MongoDatabaseConnectionHolder(final DatabaseConfigurationFactory databaseConfigurationFactory) {
        DatabaseConfiguration databaseConfiguration = databaseConfigurationFactory.createConfiguration();
        MongoClient mongoClient = new MongoClient(databaseConfiguration.getHostName(), databaseConfiguration.getConnectionPort());
        database = mongoClient.getDatabase(databaseConfiguration.getDatabaseName());
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
