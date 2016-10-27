package com.openshop.product.domain;

import static com.openshop.validation.Validation.notNull;
import static java.util.Collections.unmodifiableList;

import java.net.URL;
import java.util.List;

import com.openshop.domain.IdentifiableEntity;

/**
 * Domain object describing a certain domain.
 *
 * @author Laszlo_Sisa
 */
public final class Product implements IdentifiableEntity {

    private final String id;
    private final String name;
    private final String description;
    private final Price price;
    private final List<URL> images;
    private final List<Component> components;

    private Product(final Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        price = builder.price;
        images = builder.images != null ? unmodifiableList(builder.images) : null;
        components = builder.components != null ? unmodifiableList(builder.components) : null;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public List<URL> getImages() {
        return images;
    }

    public List<Component> getComponents() {
        return components;
    }

    public static class Builder {

        private String id = IdentifiableEntity.NEW_ENTITY_ID;
        private String name;
        private String description;
        private Price price;
        private List<URL> images;
        private List<Component> components;

        public Builder withIdFrom(final Product productFrom) {
            this.id = productFrom.getId();
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withPrice(final Price price) {
            this.price = price;
            return this;
        }

        public Builder withImages(final List<URL> images) {
            this.images = images;
            return this;
        }

        public Builder withComponents(final List<Component> components) {
            this.components = components;
            return this;
        }

        public Product build() {
            notNull(id, "id can't be null");
            notNull(name, "name can't be null");
            notNull(price, "price can't be null");
            return new Product(this);
        }

    }

}
