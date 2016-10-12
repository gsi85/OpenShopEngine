package com.openshop.product.delete;

import static com.openshop.validation.Validation.notNull;

import javax.inject.Inject;
import javax.inject.Named;

import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Default implementation of {@link DeleteProductService}.
 *
 * @author Laszlo_Sisa
 */
@Named("deleteProductService")
public class DefaultDeleteProductService implements DeleteProductService {

    @Inject
    private DeleteProductDao deleteProductDao;

    public int deleteProduct(final DeleteProductRequestContext context) throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(context);
        return deleteProductDao.deleteProduct(context);
    }

    private void validateContext(final DeleteProductRequestContext context) {
        notNull(context, "context must not be null!");
    }
}
