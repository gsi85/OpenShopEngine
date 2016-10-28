package com.openshop.transformer.document;

import static org.bson.Document.parse;

import org.bson.Document;

import com.openshop.parser.JsonParser;
import com.openshop.product.domain.Product;

/**
 * {@link Product} specific implementation of {@link EntityToDocumentTransformer}.
 *
 * @author Laszlo_Sisa
 */
public class ProductToDocumentTransformer implements EntityToDocumentTransformer<Product> {

    private final JsonParser<Product> jsonParser;

    /**
     * DI constructor.
     *
     * @param jsonParser {@link JsonParser}
     */
    public ProductToDocumentTransformer(final JsonParser<Product> jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Override
    public Document tansformEntity(final Product product, final Class<Product> typeParameterClass) {
        String entityAsJson = jsonParser.serializeObject(product);
        Document document = parse(entityAsJson);
        return document;
    }
}
