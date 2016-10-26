package com.openshop.product.alter;

import static com.openshop.validation.Validation.notNull;

import com.openshop.product.domain.Component;
import com.openshop.product.exception.ComponentOperationFailedException;

/**
 * Default implementation of {@link AlterComponentService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultAlterComponentService implements AlterComponentService {

    private final AlterComponentServiceDao alterComponentServiceDao;

    public DefaultAlterComponentService(final AlterComponentServiceDao alterComponentServiceDao) {
        this.alterComponentServiceDao = alterComponentServiceDao;
    }

    public Component upsertComponent(final AlterComponentRequestContext context) throws ComponentOperationFailedException, IllegalArgumentException {
        validateContext(context);
        return alterComponentServiceDao.upsertComponent(context);
    }

    private void validateContext(final AlterComponentRequestContext context) {
        notNull(context, "context must not be null!");
    }

}
