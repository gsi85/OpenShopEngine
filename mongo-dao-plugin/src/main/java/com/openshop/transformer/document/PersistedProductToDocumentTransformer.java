package com.openshop.transformer.document;

import static org.bson.Document.parse;

import org.bson.Document;

import com.openshop.parser.JsonParser;
import com.openshop.product.service.domain.PersistedProduct;

/**
 * {@link PersistedProduct} specific implementation of {@link EntityToDocumentTransformer}.
 *
 * @author Laszlo_Sisa
 */
public class PersistedProductToDocumentTransformer implements EntityToDocumentTransformer<PersistedProduct> {

    private static final String PRODUCT_KEY = "product";
    private static final String COMPONENTS_KEY = "components";
    private final JsonParser<PersistedProduct> jsonParser;

    /**
     * DI constructor.
     *
     * @param jsonParser {@link JsonParser}
     */
    public PersistedProductToDocumentTransformer(final JsonParser<PersistedProduct> jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Override
    public Document tansformEntity(final PersistedProduct product, final Class<PersistedProduct> typeParameterClass) {
        String entityAsJson = jsonParser.serializeObject(product);
        Document document = parse(entityAsJson);
        removeComponentsStructure(document);
        return document;
    }

    private void removeComponentsStructure(final Document document) {
        ((Document) document.get(PRODUCT_KEY)).remove(COMPONENTS_KEY);
    }
}
