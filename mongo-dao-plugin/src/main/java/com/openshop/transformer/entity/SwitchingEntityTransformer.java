package com.openshop.transformer.entity;

import static com.openshop.validation.Validation.notNull;

import java.util.Map;

import org.bson.Document;

import com.openshop.domain.IdentifiableEntity;

/**
 * Switching implementation of {@link DocumentToEntityTransformer}.
 *
 * @author Laszlo_Sisa
 */
public class SwitchingEntityTransformer<T extends IdentifiableEntity> implements DocumentToEntityTransformer<T> {

    private static final String OBJECT_ID_KEY = "_id";
    private static final String ID_KEY = "id";

    private final Map<Class, DocumentToEntityTransformer> transformerMap;

    /**
     * DI constructor.
     *
     * @param transformerMap map of transformers, where the key is entities class
     */
    public SwitchingEntityTransformer(final Map<Class, DocumentToEntityTransformer> transformerMap) {
        this.transformerMap = transformerMap;
    }

    @Override
    public T transformDocument(final Document document, final Class<T> typeParameterClass) {
        applyGenericTransformation(document);
        DocumentToEntityTransformer<T> transformer = getTransformer(typeParameterClass);
        return transformer.transformDocument(document, typeParameterClass);
    }

    private DocumentToEntityTransformer getTransformer(final Class<T> typeParameterClass) {
        DocumentToEntityTransformer transformer = transformerMap.get(typeParameterClass);
        notNull(transformer, "can't fin entity to document transformer for: " + typeParameterClass);
        return transformer;
    }

    private void applyGenericTransformation(final Document document) {
        document.put(ID_KEY, document.get(OBJECT_ID_KEY).toString());
    }
}
