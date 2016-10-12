package com.openshop.product.retrieve;

import static com.openshop.validation.Validation.notNull;

import com.openshop.product.domain.Condition;
import java.util.Collections;
import java.util.List;

/**
 * Context object containing information necessary to retrieve products.
 *
 * @author Laszlo_Sisa
 */
public class RetrieveProductRequestContext {

    private final List<Condition> conditionsToMatch;

    public RetrieveProductRequestContext(final List<Condition> conditionsToMatch) {
        notNull(conditionsToMatch, "conditionsToMatch list can't be null!");
        this.conditionsToMatch = Collections.unmodifiableList(conditionsToMatch);
    }

    public List<Condition> getConditionsToMatch() {
        return conditionsToMatch;
    }
}
