package com.openshop.product.delete;

import static com.openshop.validation.Validation.notNull;

import java.util.Collections;
import java.util.List;

import com.openshop.product.domain.Condition;

/**
 * Context object containing information necessary to delete products.
 *
 * @author Laszlo_Sisa
 */
public class DeleteProductRequestContext {

    private final List<Condition> conditionsToMatch;

    public DeleteProductRequestContext(final List<Condition> conditionsToMatch) {
        notNull(conditionsToMatch, "conditionsToMatch list can't be null!");
        this.conditionsToMatch = Collections.unmodifiableList(conditionsToMatch);
    }

    public List<Condition> getConditionsToMatch() {
        return conditionsToMatch;
    }

}
