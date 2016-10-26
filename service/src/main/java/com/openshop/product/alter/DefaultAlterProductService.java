package com.openshop.product.alter;

import static com.openshop.validation.Validation.notNull;

import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Default implementation of {@link AlterProductService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultAlterProductService implements AlterProductService {

    private AlterProductServiceDao alterProductServiceDao;

    public Product upsertProduct(final AlterProductRequestContext context) throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(context);
        return alterProductServiceDao.upsertProduct(context);
    }

    private void validateContext(final AlterProductRequestContext context) {
        notNull(context, "context must not be null!");
    }
}
