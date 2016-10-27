package com.openshop.product.domain;

import com.openshop.domain.IdentifiableEntity;

/**
 * Domain object describing a component of a {@link Product}.
 *
 * @author Laszlo_Sisa
 */
public final class Component implements IdentifiableEntity {

    private final String id;
    private final String description;

    private Component(final Builder builder) {
        id = builder.id;
        description = builder.description;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Component{" + "id='" + id + '\'' + ", description='" + description + '\'' + '}';
    }

    public static class Builder {

        private String id = IdentifiableEntity.NEW_ENTITY_ID;
        private String description;

        public Builder withIdFrom(final Component componentFrom) {
            this.id = componentFrom.getId();
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Component build() {
            return new Component(this);
        }
    }

}
