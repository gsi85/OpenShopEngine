package com.openshop.product.domain;

/**
 * @author Laszlo_Sisa
 */
public class Condition<T> {

    private final T left;
    private final Matcher matcher;
    private final T right;

    public Condition(final T left, final Matcher matcher, final T right) {
        this.left = left;
        this.matcher = matcher;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public T getRight() {
        return right;
    }

    public enum Matcher {
        EQUALS,
        CONTAINES,
        LESS_THEN,
        GREATHER_THEN;
    }

}
