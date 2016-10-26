package com.openshop.product.delete;

import static com.openshop.validation.Validation.notNull;

import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Default implementation of {@link DeleteProductService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultDeleteProductService implements DeleteProductService {

    private DeleteProductDao deleteProductDao;

    public int deleteProduct(final DeleteProductRequestContext context) throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(context);
        return deleteProductDao.deleteProduct(context);
    }

    private void validateContext(final DeleteProductRequestContext context) {
        notNull(context, "context must not be null!");
    }
}
