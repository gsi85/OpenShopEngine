package com.openshop.product.retrieve;

import static com.openshop.validation.Validation.notNull;

import java.util.List;

import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Default implementation of {@link RetrieveProductService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultRetrieveProductService implements RetrieveProductService {

    private RetrieveProductDao retrieveProductDao;

    public List<Product> retrieveProducts(final RetrieveProductRequestContext context)
        throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(context);
        return retrieveProductDao.retrieveProduct(context);
    }

    private void validateContext(final RetrieveProductRequestContext context) {
        notNull(context, "context must not be null!");
    }
}
