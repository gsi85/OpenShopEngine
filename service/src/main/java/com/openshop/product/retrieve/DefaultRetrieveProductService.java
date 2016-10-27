package com.openshop.product.retrieve;

import static com.openshop.validation.Validation.notNull;

import java.util.List;

import com.openshop.dao.EntityDao;
import com.openshop.product.domain.Product;
import com.openshop.product.exception.ProductOperationFailedException;

/**
 * Default implementation of {@link RetrieveProductService}.
 *
 * @author Laszlo_Sisa
 */
public class DefaultRetrieveProductService implements RetrieveProductService {

    private EntityDao<Product> retrieveProductDao;

    @Override
    public List<Product> retrieveProducts(final RetrieveEntityRequestContext context)
        throws ProductOperationFailedException, IllegalArgumentException {
        validateContext(context);
        return retrieveProductDao.retrieveEntities(context, Product.class);
    }

    private void validateContext(final RetrieveEntityRequestContext context) {
        notNull(context, "context must not be null!");
    }
}
