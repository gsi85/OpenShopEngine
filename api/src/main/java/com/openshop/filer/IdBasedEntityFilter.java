package com.openshop.filer;

/**
 * @author Laszlo_Sisa
 */
public class IdBasedEntityFilter implements EntityFilter {

    private final Condition condition;

    public IdBasedEntityFilter(final String id) {
        condition = new ValueMatcherCondition("id", ValueMatcherCondition.Matcher.EQUALS, id);
    }

    @Override
    public Condition getCondition() {
        return condition;
    }
}
