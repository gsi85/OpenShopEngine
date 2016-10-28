package com.openshop.filer;

/**
 * @author Laszlo_Sisa
 */
public class ValueMatcherCondition implements Condition {

    private final String key;
    private final Matcher matcher;
    private final Object valueToMatch;

    public ValueMatcherCondition(final String key, final Matcher matcher, final Object valueToMatch) {
        this.key = key;
        this.matcher = matcher;
        this.valueToMatch = valueToMatch;
    }

    public String getKey() {
        return key;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public Object getValueToMatch() {
        return valueToMatch;
    }

    public enum Matcher {
        EQUALS,
        CONTAINES,
        LESS_THEN,
        GREATHER_THEN;
    }

}
