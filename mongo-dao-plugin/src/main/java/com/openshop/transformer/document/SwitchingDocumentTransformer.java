package com.openshop.transformer.document;

import static com.openshop.validation.Validation.notNull;

import java.util.Map;

import org.bson.Document;

import com.openshop.domain.IdentifiableEntity;

/**
 * Switching implementation of {@link EntityToDocumentTransformer}.
 *
 * @author Laszlo_Sisa
 */
public class SwitchingDocumentTransformer<T extends IdentifiableEntity> implements EntityToDocumentTransformer<T> {

    private static final String ID_KEY = "id";
    private final Map<Class, EntityToDocumentTransformer> transformerMap;

    /**
     * DI constructor.
     *
     * @param transformerMap map of transformers, where the key is entities class
     */
    public SwitchingDocumentTransformer(final Map<Class, EntityToDocumentTransformer> transformerMap) {
        this.transformerMap = transformerMap;
    }

    @Override
    public Document tansformEntity(final T entity, final Class<T> typeParameterClass) {
        EntityToDocumentTransformer transformer = getTransformer(typeParameterClass);
        Document document = transformer.tansformEntity(entity, typeParameterClass);
        applyGenericTransformation(document);
        return document;
    }

    private EntityToDocumentTransformer getTransformer(final Class<T> typeParameterClass) {
        EntityToDocumentTransformer transformer = transformerMap.get(typeParameterClass);
        notNull(transformer, "can't fin entity to document transformer for: " + typeParameterClass);
        return transformer;
    }

    private void applyGenericTransformation(final Document document) {
        document.remove(ID_KEY);
    }

}
