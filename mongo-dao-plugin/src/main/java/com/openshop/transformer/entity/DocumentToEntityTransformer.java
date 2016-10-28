package com.openshop.transformer.entity;

import org.bson.Document;

import com.openshop.domain.IdentifiableEntity;

/**
 * Transformer for creating an entity from a {@link Document}.
 *
 * @author Laszlo_Sisa
 */
public interface DocumentToEntityTransformer<T extends IdentifiableEntity> {

    T transformDocument(final Document document, final Class<T> typeParameterClass);

}
