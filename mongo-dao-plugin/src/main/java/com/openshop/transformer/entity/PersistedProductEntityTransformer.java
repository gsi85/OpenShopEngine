package com.openshop.transformer.entity;

import org.bson.Document;

import com.openshop.parser.JsonParser;
import com.openshop.product.service.domain.PersistedProduct;

/**
 * {@link PersistedProduct} specific implementation of {@link DocumentToEntityTransformer}.
 *
 * @author Laszlo_Sisa
 */
public class PersistedProductEntityTransformer implements DocumentToEntityTransformer<PersistedProduct> {

    private final JsonParser<PersistedProduct> jsonParser;

    /**
     * DI constructor.
     *
     * @param jsonParser {@link JsonParser}
     */
    public PersistedProductEntityTransformer(final JsonParser<PersistedProduct> jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Override
    public PersistedProduct transformDocument(final Document document, final Class<PersistedProduct> typeParameterClass) {
        return jsonParser.parseString(document.toJson(), PersistedProduct.class);
    }
}
