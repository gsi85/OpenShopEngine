package com.openshop.product.domain;

import static com.openshop.validation.Validation.notNull;
import static java.util.Collections.unmodifiableList;

import java.net.URL;
import java.util.List;

/**
 * Domain object describing a certain domain.
 *
 * @author Laszlo_Sisa
 */
public final class Product {

    private final long id;
    private final String name;
    private final String description;
    private final Price price;
    private final List<URL> images;
    private final List<Product> subProducts;

    private Product(final Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        price = builder.price;
        images = builder.images != null ? unmodifiableList(builder.images) : null;
        subProducts = builder.subProducts != null ? unmodifiableList(builder.subProducts) : null;
    }

    public long getId() {
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

    public List<Product> getSubProducts() {
        return subProducts;
    }

    public static class Builder {

        private long id;
        private String name;
        private String description;
        private Price price;
        private List<URL> images;
        private List<Product> subProducts;

        public Builder withId(final long id) {
            this.id = id;
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

        public Builder withSubProducts(final List<Product> subProducts) {
            this.subProducts = subProducts;
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
