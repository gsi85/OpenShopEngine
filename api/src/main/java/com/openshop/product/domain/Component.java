package com.openshop.product.domain;

import static java.util.Collections.unmodifiableList;

import java.net.URL;
import java.util.List;

import com.openshop.domain.IdentifiableEntity;

/**
 * Domain object describing a component of a {@link Product}.
 *
 * @author Laszlo_Sisa
 */
public final class Component implements IdentifiableEntity {

    private final String id;
    private final String name;
    private final String description;
    private final List<URL> images;

    private Component(final Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        images = builder.images != null ? unmodifiableList(builder.images) : null;
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

    public List<URL> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Component{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }

    public static class Builder {

        private String id = IdentifiableEntity.NEW_ENTITY_ID;
        private String name;
        private String description;
        private List<URL> images;

        public Builder withIdFrom(final Component componentFrom) {
            id = componentFrom.getId();
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

        public Builder withImages(final List<URL> images) {
            this.images = images;
            return this;
        }

        public Component build() {
            return new Component(this);
        }

    }

}
