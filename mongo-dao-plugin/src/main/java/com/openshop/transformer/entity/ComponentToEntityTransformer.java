package com.openshop.transformer.entity;

import org.bson.Document;

import com.openshop.parser.JsonParser;
import com.openshop.product.domain.Component;

/**
 * @author Laszlo_Sisa
 */
public class ComponentToEntityTransformer implements DocumentToEntityTransformer<Component> {

    private final JsonParser<Component> jsonParser;

    /**
     * DI constructor.
     *
     * @param jsonParser {@link JsonParser}
     */
    public ComponentToEntityTransformer(final JsonParser<Component> jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Override
    public Component transformDocument(final Document document, final Class<Component> typeParameterClass) {
        return jsonParser.parseString(document.toJson(), Component.class);
    }
}
