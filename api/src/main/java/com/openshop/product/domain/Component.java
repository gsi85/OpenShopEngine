package com.openshop.product.domain;

/**
 * Domain object describing a component of a {@link Product}.
 *
 * @author Laszlo_Sisa
 */
public final class Component {

    public static final String NEW_INSTANCE_ID = "-1";

    private final String id;

    private Component(final Builder builder) {
        id = builder.id;
    }

    public String getId() {
        return id;
    }

    public static class Builder {

        private String id = NEW_INSTANCE_ID;

        public Builder withId(final String id) {
            this.id = id;
            return this;
        }

        public Component build() {
            return new Component(this);
        }
    }

}
