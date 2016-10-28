package com.openshop.transformer.document;

import com.openshop.domain.IdentifiableEntity;
import org.bson.Document;

/**
 * Transformer for creating a {@link Document} from an entity
 *
 * @author Laszlo_Sisa
 */
public interface EntityToDocumentTransformer<T extends IdentifiableEntity> {

    Document tansformEntity(final T entity, final Class<T> typeParameterClass);

}
