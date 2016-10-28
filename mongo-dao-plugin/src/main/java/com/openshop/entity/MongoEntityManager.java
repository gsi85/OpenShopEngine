package com.openshop.entity;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.openshop.connection.MongoDatabaseConnectionHolder;
import com.openshop.domain.IdentifiableEntity;
import com.openshop.transformer.document.EntityToDocumentTransformer;
import com.openshop.transformer.entity.DocumentToEntityTransformer;

/**
 * Mongo DB specific implementation of {@link EntityManager}.
 *
 * @author Laszlo_Sisa
 */
public class MongoEntityManager<T extends IdentifiableEntity> implements EntityManager<T> {

    private static final String OBJECT_ID_KEY = "_id";
    private static final int SUCCESSFUL_SINGLE_ENTITY_OPERATION_COUNT = 1;

    private final MongoDatabaseConnectionHolder connectionHolder;
    private final EntityToDocumentTransformer<T> entityToDocumentTransformer;
    private final DocumentToEntityTransformer<T> documentToEntityTransformer;

    /**
     * DI constructor.
     *  @param entityToDocumentTransformer {@link EntityToDocumentTransformer}
     * @param connectionHolder {@link MongoDatabaseConnectionHolder}
     * @param documentToEntityTransformer {@link DocumentToEntityTransformer}
     */
    public MongoEntityManager(final EntityToDocumentTransformer<T> entityToDocumentTransformer, final MongoDatabaseConnectionHolder connectionHolder,
            final DocumentToEntityTransformer<T> documentToEntityTransformer) {
        this.entityToDocumentTransformer = entityToDocumentTransformer;
        this.connectionHolder = connectionHolder;
        this.documentToEntityTransformer = documentToEntityTransformer;
    }

    @Override
    public T insertEntity(final T entity, final Class<T> typeParameterClass) {
        Document document = createDocumentFromEntity(entity, typeParameterClass);
        MongoCollection<Document> collection = getCollection(typeParameterClass);
        collection.insertOne(document);
        return createEntityFromDocument(document, typeParameterClass);
    }

    @Override
    public T findById(final String id, final Class<T> typeParameterClass) {
        MongoCollection<Document> collection = getCollection(typeParameterClass);
        Document firstDocument = collection.find(createObjectIdFilter(id)).first();
        return createEntityFromDocument(firstDocument, typeParameterClass);
    }

    @Override
    public T updateEntry(final T entity, final Class<T> typeParameterClass) {
        Document document = createDocumentFromEntity(entity, typeParameterClass);
        MongoCollection<Document> collection = getCollection(typeParameterClass);
        UpdateResult updateResult = collection.updateOne(createObjectIdFilter(entity.getId()), new Document("$set", document));
        boolean successful = updateResult.getModifiedCount() == SUCCESSFUL_SINGLE_ENTITY_OPERATION_COUNT;
        return successful ? findById(entity.getId(), typeParameterClass) : null;
    }

    @Override
    public boolean deleteEntity(final T entity, final Class<T> typeParameterClass) {
        MongoCollection<Document> collection = getCollection(typeParameterClass);
        DeleteResult result = collection.deleteOne(createObjectIdFilter(entity.getId()));
        return result.getDeletedCount() == SUCCESSFUL_SINGLE_ENTITY_OPERATION_COUNT;
    }

    private MongoCollection<Document> getCollection(final Class<T> typeParameterClass) {
        return connectionHolder.getDatabase().getCollection(typeParameterClass.getName());
    }

    private Document createDocumentFromEntity(final T entity, final Class<T> typeParameterClass) {
        return entityToDocumentTransformer.tansformEntity(entity, typeParameterClass);
    }

    private T createEntityFromDocument(final Document document, final Class<T> typeParameterClass) {
        return documentToEntityTransformer.transformDocument(document, typeParameterClass);
    }

    private Bson createObjectIdFilter(final String id) {
        return Filters.eq(OBJECT_ID_KEY, new ObjectId(id));
    }

}
