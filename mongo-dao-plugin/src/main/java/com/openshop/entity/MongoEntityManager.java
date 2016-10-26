package com.openshop.entity;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.openshop.connection.MongoDatabaseConnectionHolder;
import com.openshop.parser.ObjectToJsonParser;

/**
 * Mongo DB specific implementation of {@link EntityManager}.
 *
 * @author Laszlo_Sisa
 */
public class MongoEntityManager<T> implements EntityManager<T> {

    private final ObjectToJsonParser objectToJsonParser;
    private final MongoDatabaseConnectionHolder connectionHolder;

    public MongoEntityManager(final ObjectToJsonParser objectToJsonParser, final MongoDatabaseConnectionHolder connectionHolder) {
        this.objectToJsonParser = objectToJsonParser;
        this.connectionHolder = connectionHolder;
    }

    public String insertEntity(final T entityToInsert, final Class<T> typeParameterClass) {
        String entityAsJson = serializeObject(entityToInsert);
        Document document = parseEntity(entityAsJson);
        MongoCollection<Document> collection = getCollection(typeParameterClass);
        collection.insertOne(document);
        return getObjectId(document);
    }

    private String serializeObject(final T entityToInsert) {
        return objectToJsonParser.serializeObject(entityToInsert);
    }

    private Document parseEntity(final String entityAsJson) {
        return Document.parse(entityAsJson);
    }

    private MongoCollection<Document> getCollection(final Class<T> typeParameterClass) {
        return connectionHolder.getDatabase().getCollection(typeParameterClass.getName());
    }

    private String getObjectId(final Document document) {
        return document.get("_id").toString();
    }
}
