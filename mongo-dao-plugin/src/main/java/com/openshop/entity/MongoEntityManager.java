package com.openshop.entity;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.openshop.connection.MongoDatabaseConnectionHolder;
import com.openshop.domain.IdentifiableEntity;
import com.openshop.parser.JsonParser;

/**
 * Mongo DB specific implementation of {@link EntityManager}.
 *
 * @author Laszlo_Sisa
 */
public class MongoEntityManager<T extends IdentifiableEntity> implements EntityManager<T> {

    private static final String OBJECT_ID_KEY = "_id";
    private static final int SUCCESSFUL_SINGLE_DELETION_COUNT = 1;

    private final JsonParser<T> jsonParser;
    private final MongoDatabaseConnectionHolder connectionHolder;

    /**
     * DI constructor.
     *
     * @param jsonParser {@link JsonParser}
     * @param connectionHolder {@link MongoDatabaseConnectionHolder}
     */
    public MongoEntityManager(final JsonParser<T> jsonParser, final MongoDatabaseConnectionHolder connectionHolder) {
        this.jsonParser = jsonParser;
        this.connectionHolder = connectionHolder;
    }

    @Override
    public String insertEntity(final T entity, final Class<T> typeParameterClass) {
        Document document = createDocumentFromEntity(entity);
        MongoCollection<Document> collection = getCollection(typeParameterClass);
        collection.insertOne(document);
        return document.get(OBJECT_ID_KEY).toString();
    }

    @Override
    public T findById(final String id, final Class<T> typeParameterClass) {
        MongoCollection<Document> collection = getCollection(typeParameterClass);
        Document firstDocument = collection.find(createObjectIdFilter(id)).first();
        firstDocument.put("id", id);
        return jsonParser.parseString(firstDocument.toJson(), typeParameterClass);
    }

    @Override
    public boolean updateEntry(final T entity, final Class<T> typeParameterClass) {
        Document document = createDocumentFromEntity(entity);
        MongoCollection<Document> collection = getCollection(typeParameterClass);
        return collection.updateOne(createObjectIdFilter(entity.getId()), new Document("$set", document)).wasAcknowledged();
    }

    @Override
    public boolean deleteEntity(final T entity, final Class<T> typeParameterClass) {
        MongoCollection<Document> collection = getCollection(typeParameterClass);
        DeleteResult result = collection.deleteOne(createObjectIdFilter(entity.getId()));
        return result.getDeletedCount() == SUCCESSFUL_SINGLE_DELETION_COUNT;
    }

    private Bson createObjectIdFilter(final String id) {
        return Filters.eq(OBJECT_ID_KEY, new ObjectId(id));
    }

    private Document createDocumentFromEntity(final T entity) {
        String entityAsJson = jsonParser.serializeObject(entity);
        Document document = Document.parse(entityAsJson);
        document.remove("id");
        return document;
    }

    private MongoCollection<Document> getCollection(final Class<T> typeParameterClass) {
        return connectionHolder.getDatabase().getCollection(typeParameterClass.getName());
    }

}
