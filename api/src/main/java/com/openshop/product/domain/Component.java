package com.openshop.product.domain;

/**
 * Domain object describing a component of a {@link Product}.
 *
 * @author Laszlo_Sisa
 */
public final class Component {

    public static final long NEW_INSTANCE_ID = -1;

    private final long id;

    private Component(final Builder builder) {
        id = builder.id;
    }

    public static long getNewInstanceId() {
        return NEW_INSTANCE_ID;
    }

    public static class Builder {

        private long id = NEW_INSTANCE_ID;

        public Builder withId(final long id) {
            this.id = id;
            return this;
        }

        public Component build() {
            return new Component(this);
        }
    }

}
