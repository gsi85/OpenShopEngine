package com.openshop.product.alter;

import static com.openshop.validation.Validation.notNull;

import javax.inject.Inject;
import javax.inject.Named;

import com.openshop.product.domain.Component;
import com.openshop.product.exception.ComponentOperationFailedException;

/**
 * Default implementation of {@link AlterComponentService}.
 *
 * @author Laszlo_Sisa
 */
@Named("alterComponentService")
public class DefaultAlterComponentService implements AlterComponentService {

    @Inject
    private AlterComponentServiceDab alterComponentServiceDab;

    public Component upsertComponent(final AlterComponentRequestContext context) throws ComponentOperationFailedException, IllegalArgumentException {
        validateContext(context);
        return null;
    }

    private void validateContext(final AlterComponentRequestContext context) {
        notNull(context, "context must not be null!");
    }

}
