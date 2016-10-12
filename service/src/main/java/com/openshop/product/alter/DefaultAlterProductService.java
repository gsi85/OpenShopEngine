package com.openshop.product.alter;

import static com.openshop.validation.Validation.notNull;

import javax.inject.Inject;
import javax.inject.Named;

import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Default implementation of {@link AlterProductService}.
 *
 * @author Laszlo_Sisa
 */
@Named("alterProductService")
public class DefaultAlterProductService implements AlterProductService {

    @Inject
    private AlterProductServiceDao alterProductServiceDao;

    public Product upsertProduct(final AlterProductRequestContext context) throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(context);
        return alterProductServiceDao.upsertProduct(context);
    }

    private void validateContext(final AlterProductRequestContext context) {
        notNull(context, "context must not be null!");
    }
}
