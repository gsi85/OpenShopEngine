package com.openshop.transformer.document;

import static org.bson.Document.parse;

import org.bson.Document;

import com.openshop.parser.JsonParser;
import com.openshop.product.domain.Component;

/**
 * {@link Component} specific implementation of {@link EntityToDocumentTransformer}.
 *
 * @author Laszlo_Sisa
 */
public class ComponentToDocumentTransformer implements EntityToDocumentTransformer<Component> {

    private final JsonParser<Component> jsonParser;

    /**
     * DI constructor.
     *
     * @param jsonParser {@link JsonParser}
     */
    public ComponentToDocumentTransformer(final JsonParser<Component> jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Override
    public Document tansformEntity(final Component component, final Class<Component> typeParameterClass) {
        String entityAsJson = jsonParser.serializeObject(component);
        return parse(entityAsJson);
    }

}
